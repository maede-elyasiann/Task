package org.example.lookinsure.service;

import org.example.lookinsure.enumaration.ReviewStatus;
import org.example.lookinsure.service.dto.ProductReviewDTO;
import org.example.lookinsure.service.dto.ReviewDTO;

import java.util.List;

public interface ReviewService {

    List<ReviewDTO> findByStatus(Long productId, ReviewStatus status);
    void updateReviewStatus(Long reviewId, ReviewStatus approved);

    ProductReviewDTO getProductReviewData(Long productId);
}
