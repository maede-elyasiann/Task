package org.example.lookinsure.mapper;

import org.example.lookinsure.domain.Provider;
import org.example.lookinsure.service.request.ProviderRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProviderMapper {

    Provider toEntity(ProviderRequest request);
}
