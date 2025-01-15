package org.example.lookinsure.mapper;

import org.example.lookinsure.domain.Product;
import org.example.lookinsure.domain.Provider;
import org.example.lookinsure.service.dto.ProductConfigDTO;
import org.example.lookinsure.service.dto.ProductReviewDTO;
import org.example.lookinsure.service.request.ProductRequest;
import org.example.lookinsure.service.response.ProductResponse;
import org.mapstruct.*;


import java.util.Map;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @BeanMapping(qualifiedByName = "setProvider")
    Product toEntity(ProductRequest request, @Context Provider provider);

    @AfterMapping
    @Named("setProvider")
    default void setProvider(@Context Provider provider, @MappingTarget Product product){
        product.setProvider(provider);
    }

    ProductResponse toProductResponse(Product product,
                                      Map<Long, Integer> productPriceMap,
                                      ProductReviewDTO productReview,
                                      ProductConfigDTO productConfig);

    @AfterMapping
    default void setPrice(Map<Long, Double> productPriceMap, Product product, @MappingTarget ProductResponse productResponse){
        Double price = productPriceMap.getOrDefault(product.getId(), 0.0);
        productResponse.setPrice(price);
    }
}
