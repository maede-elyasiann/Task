package org.example.lookinsure.api;

import lombok.AllArgsConstructor;
import org.example.lookinsure.service.request.ProductConfigRequest;
import org.example.lookinsure.service.ProductConfigService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/product-config")
@AllArgsConstructor
public class ProductConfigController {

    private final ProductConfigService productConfigService;

    @PostMapping
    public ResponseEntity<Void> config(@RequestBody ProductConfigRequest request) {
        productConfigService.saveConfig(request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        productConfigService.deleteConfig(id);
        return ResponseEntity.ok().build();
    }
}
