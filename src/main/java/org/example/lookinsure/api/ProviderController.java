package org.example.lookinsure.api;

import lombok.RequiredArgsConstructor;
import org.example.lookinsure.service.ProviderService;
import org.example.lookinsure.service.request.ProviderRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/provider")
@RequiredArgsConstructor
public class ProviderController {

    private final ProviderService providerService;

    @PostMapping
    public ResponseEntity<Long> createProvider(@RequestBody ProviderRequest request) {
        Long providerId = providerService.create(request);
        return ResponseEntity.ok(providerId);
    }
}
