package org.example.lookinsure.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.lookinsure.domain.Provider;
import org.example.lookinsure.mapper.ProviderMapper;
import org.example.lookinsure.repository.ProviderRepository;
import org.example.lookinsure.service.ProviderService;
import org.example.lookinsure.service.request.ProviderRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProviderServiceImpl implements ProviderService {

    private final ProviderRepository repository;
    private final ProviderMapper mapper;

    @Override
    public Long create(ProviderRequest request) {
        Provider saved = repository.save(mapper.toEntity(request));
        return saved.getId();
    }
}
