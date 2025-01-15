package org.example.lookinsure.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.example.lookinsure.domain.Product;
import org.example.lookinsure.domain.Provider;
import org.example.lookinsure.exception.NotFoundException;
import org.example.lookinsure.gateway.PriceEnquiryGateway;
import org.example.lookinsure.mapper.ProductMapper;
import org.example.lookinsure.repository.ProductRepository;
import org.example.lookinsure.repository.ProviderRepository;
import org.example.lookinsure.service.ProductConfigService;
import org.example.lookinsure.service.ProductService;
import org.example.lookinsure.service.ReviewService;
import org.example.lookinsure.service.constant.Constant;
import org.example.lookinsure.service.dto.ProductConfigDTO;
import org.example.lookinsure.service.request.ProductRequest;
import org.example.lookinsure.service.response.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProviderRepository providerRepository;
    private final ProductMapper mapper;
    private final ReviewService reviewService;
    private final ProductConfigService productConfigService;
    private final PriceEnquiryGateway priceEnquiryGateway;

    @Override
    public Long create(ProductRequest request) {
        Provider provider = providerRepository.findById(request.getProviderId())
                        .orElseThrow(() -> new NotFoundException(Constant.ExceptionMessage.PROVIDER_NOT_FOUND));
        Product entity = mapper.toEntity(request, provider);
        return repository.save(entity).getId();
    }

    @Override
    public List<ProductResponse> getAll() {
        List<ProductResponse> toReturn = new ArrayList<>();
        List<ProductConfigDTO> visibleProducts = productConfigService.getVisibleProducts();

        if (ObjectUtils.isEmpty(visibleProducts))
            return Collections.emptyList();

        List<Long> visibleProductIds = visibleProducts.stream().map(ProductConfigDTO::getProductId).toList();
        List<Product> products = repository.findAllById(visibleProductIds);
        try {
            //inquire products' price
            Map<Long, Integer> productPriceMap = priceEnquiryGateway.getPrice(products.stream().map(Product::getId).toList());

            toReturn = products.stream()
                    .map(product -> mapper.toProductResponse(
                            product,
                            productPriceMap,
                            reviewService.getProductReviewData(product.getId()),
                            this.getProductConfig(product.getId(), visibleProducts)))
                    .toList();

        } catch (Exception e) {
            log.error("Error occurred while processing products", e);
        }
        return toReturn;
    }

    private ProductConfigDTO getProductConfig(Long productId, List<ProductConfigDTO> visibleProducts) {
        return visibleProducts.stream()
                .filter(config -> config.getProductId().equals(productId))
                .findFirst()
                .orElse(null);
    }
}
