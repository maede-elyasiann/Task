package org.example.lookinsure.service;

import org.example.lookinsure.service.request.ProductRequest;
import org.example.lookinsure.service.response.ProductResponse;

import java.util.List;

public interface ProductService {

    Long create(ProductRequest productRequest);

    List<ProductResponse> getAll();
}
