package org.example.lookinsure.service.request;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ProductReviewRequest {

    private Long productId;
    private String comment;
    private Double rate;
}
