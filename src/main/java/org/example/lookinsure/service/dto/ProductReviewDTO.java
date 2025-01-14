package org.example.lookinsure.service.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class ProductReviewDTO {

    private Long productId;
    private List<CommentDTO> comments;
    private Double averageRate;
    private Long totalReviews;

}
