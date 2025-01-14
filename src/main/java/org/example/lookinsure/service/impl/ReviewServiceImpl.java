package org.example.lookinsure.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.example.lookinsure.config.properties.ReviewProperties;
import org.example.lookinsure.domain.Review;
import org.example.lookinsure.enumaration.ReviewStatus;
import org.example.lookinsure.exception.NotFoundException;
import org.example.lookinsure.mapper.ReviewMapper;
import org.example.lookinsure.repository.ReviewRepository;
import org.example.lookinsure.service.ReviewService;
import org.example.lookinsure.service.constant.Constant;
import org.example.lookinsure.service.dto.CommentDTO;
import org.example.lookinsure.service.dto.ProductReviewDTO;
import org.example.lookinsure.service.dto.ReviewDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository repository;
    private final ReviewMapper mapper;
    private final ReviewProperties reviewProps;


    @Override
    public List<ReviewDTO> findByStatus(Long productId, ReviewStatus status) {
        return mapper.toDTOList(repository.findByProductIdAndReviewStatus(productId, status));
    }

    @Override
    public void updateReviewStatus(Long reviewId, ReviewStatus status) {
        Review review = repository.findById(reviewId)
                .orElseThrow(() -> new NotFoundException(Constant.ExceptionMessage.REVIEW_NOT_FOUND));
        review.setStatus(status);
        repository.save(review);
    }

    @Override
    public ProductReviewDTO getProductReviewData(Long productId) {
        List<Review> approvedReviews = repository.findReviewsByProductId(productId, ReviewStatus.APPROVED);

        if (ObjectUtils.isEmpty(approvedReviews))
            return null;

        List<CommentDTO> commentDTOList = this.getComments(approvedReviews);
        Double averageRate = this.getAverageRate(approvedReviews);
        return mapper.toProductReviewDTOList(productId, commentDTOList, averageRate, approvedReviews.size());
    }

    private Double getAverageRate(List<Review> reviews) {
        return reviews.stream()
                .mapToDouble(Review::getRate)
                .average()
                .orElse(0.0);
    }

    private List<CommentDTO> getComments(List<Review> reviews){
        Integer limit = reviewProps.getLastVisibleCommentsThreshold();
        List<Review> reviewSubList = reviews.subList(0, Math.min(limit, reviews.size()));
        return mapper.toCommentDTOList(reviewSubList);
    }
}
