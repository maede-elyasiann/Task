package org.example.lookinsure.api;

import lombok.AllArgsConstructor;
import org.example.lookinsure.api.request.ProductConfigRequest;
import org.example.lookinsure.service.ProductConfigService;
import org.example.lookinsure.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/product-config")
@AllArgsConstructor
public class ProductConfigController {

    private final ProductConfigService reviewService;

    @PostMapping(value = "/config/{productId}")
    public ResponseEntity<Void> config(@RequestBody ProductConfigRequest request) {
        reviewService.saveConfig(request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        reviewService.deleteConfig(id);
        return ResponseEntity.ok().build();
    }
}
