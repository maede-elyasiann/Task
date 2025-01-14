package org.example.lookinsure.mapper;

import org.example.lookinsure.api.request.ProductConfigRequest;
import org.example.lookinsure.domain.ProductConfig;
import org.example.lookinsure.service.dto.ProductConfigDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductConfigMapper {

    ProductConfig toEntity(ProductConfigRequest request);

    List<ProductConfigDTO> toConfigDTOList(List<ProductConfig> configs);
}
