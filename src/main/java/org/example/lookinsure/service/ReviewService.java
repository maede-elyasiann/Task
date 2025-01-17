package org.example.lookinsure.service;

import org.example.lookinsure.enumaration.ReviewStatus;
import org.example.lookinsure.service.dto.ProductReviewDTO;
import org.example.lookinsure.service.dto.ReviewDTO;
import org.example.lookinsure.service.request.ProductReviewRequest;
import org.example.lookinsure.service.request.UpdateReviewStatusRequest;

import java.util.List;

public interface ReviewService {

    List<ReviewDTO> findByStatus(Long productId, ReviewStatus status);
    void updateReviewStatus(UpdateReviewStatusRequest request);

    ProductReviewDTO getProductReviewData(Long productId);

    void add(ProductReviewRequest request);
}
