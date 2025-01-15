package org.example.lookinsure.service;

import org.example.lookinsure.service.request.ProviderRequest;
import org.springframework.stereotype.Service;

@Service
public interface ProviderService {

    Long create(ProviderRequest request);
}
