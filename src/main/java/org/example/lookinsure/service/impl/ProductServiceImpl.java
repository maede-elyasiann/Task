package org.example.lookinsure.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.example.lookinsure.api.response.ProductResponseList;
import org.example.lookinsure.domain.Product;
import org.example.lookinsure.gateway.PriceEnquiryGateway;
import org.example.lookinsure.mapper.ProductMapper;
import org.example.lookinsure.repository.ProductRepository;
import org.example.lookinsure.service.ProductConfigService;
import org.example.lookinsure.service.ProductService;
import org.example.lookinsure.service.ReviewService;
import org.example.lookinsure.service.dto.ProductConfigDTO;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;
    private final ReviewService reviewService;
    private final ProductConfigService productConfigService;
    private final PriceEnquiryGateway priceEnquiryGateway;

    @Override
    public List<ProductResponseList> getAll() {
        List<ProductConfigDTO> visibleProducts = productConfigService.getVisibleProducts();

        if (ObjectUtils.isEmpty(visibleProducts))
            return Collections.emptyList();

        List<Long> visibleProductIds = visibleProducts.stream().map(ProductConfigDTO::getProductId).toList();
        List<Product> products = repository.findAllById(visibleProductIds);
        try {
            Map<Long, Double> productPriceMap = priceEnquiryGateway.getPrice(visibleProductIds);

        }catch (Exception e){
           log.error("Error occurred while processing products", e);
        }

        //fill them ( add price /)
        // fill product review data

        return null;
    }

}
