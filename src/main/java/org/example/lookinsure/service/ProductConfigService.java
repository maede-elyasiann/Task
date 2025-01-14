package org.example.lookinsure.service;

import org.example.lookinsure.api.request.ProductConfigRequest;
import org.example.lookinsure.service.dto.ProductConfigDTO;

import java.util.List;

public interface ProductConfigService {

    void saveConfig(ProductConfigRequest request);

    void deleteConfig(Long productId);

    List<ProductConfigDTO> getVisibleProducts();
}
