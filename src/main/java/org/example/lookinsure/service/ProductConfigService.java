package org.example.lookinsure.service;

import org.example.lookinsure.domain.ProductConfig;
import org.example.lookinsure.service.request.ProductConfigRequest;
import org.example.lookinsure.service.dto.ProductConfigDTO;

import java.util.List;

public interface ProductConfigService {

    void saveConfig(ProductConfigRequest request);

    void deleteConfig(Long productId);

    List<ProductConfigDTO> getVisibleProducts();

    ProductConfig getConfigByProductId(Long productId);
}
