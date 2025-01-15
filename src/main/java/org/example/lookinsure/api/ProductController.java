package org.example.lookinsure.api;


import lombok.RequiredArgsConstructor;
import org.example.lookinsure.service.ProductService;
import org.example.lookinsure.service.request.ProductRequest;
import org.example.lookinsure.service.response.ProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Long> createProduct(@RequestBody ProductRequest request) {
        Long productId = productService.create(request);
        return ResponseEntity.ok(productId);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<ProductResponse>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }
}
