package org.example.lookinsure.service;

import org.example.lookinsure.api.response.ProductResponseList;

import java.util.List;

public interface ProductService {

    List<ProductResponseList> getAll();
}
