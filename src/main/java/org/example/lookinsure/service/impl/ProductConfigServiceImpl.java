package org.example.lookinsure.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.lookinsure.api.request.ProductConfigRequest;
import org.example.lookinsure.domain.ProductConfig;
import org.example.lookinsure.mapper.ProductConfigMapper;
import org.example.lookinsure.repository.ProductConfigRepository;
import org.example.lookinsure.service.ProductConfigService;
import org.example.lookinsure.service.dto.ProductConfigDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
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
        List<ProductConfig> configs = repository.findByIsVisibleTrue();
        return mapper.toConfigDTOList(configs);
    }
}
