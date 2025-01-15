package org.example.lookinsure.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.lookinsure.exception.NotFoundException;
import org.example.lookinsure.service.constant.Constant;
import org.example.lookinsure.service.request.ProductConfigRequest;
import org.example.lookinsure.domain.ProductConfig;
import org.example.lookinsure.mapper.ProductConfigMapper;
import org.example.lookinsure.repository.ProductConfigRepository;
import org.example.lookinsure.service.ProductConfigService;
import org.example.lookinsure.service.dto.ProductConfigDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductConfigServiceImpl implements ProductConfigService {

    private final ProductConfigRepository repository;
    private final ProductConfigMapper mapper;

    @Override
    public void saveConfig(ProductConfigRequest request) {
        repository.save(mapper.toEntity(request));
    }

    @Override
    public void deleteConfig(Long reviewId) {
        repository.deleteById(reviewId);
    }

    @Override
    public List<ProductConfigDTO> getVisibleProducts() {
        List<ProductConfig> configs = repository.findByVisibleTrue();
        return mapper.toConfigDTOList(configs);
    }

    @Override
    public ProductConfig getConfigByProductId(Long productId) {
        return Optional.ofNullable(repository.findById(productId))
                .get()
                .orElseThrow(() -> new NotFoundException(Constant.ExceptionMessage.CONFIG_NOT_FOUND));
    }
}
