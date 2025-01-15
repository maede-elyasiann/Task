package org.example.lookinsure.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.example.lookinsure.config.ReviewProperties;
import org.example.lookinsure.domain.ProductConfig;
import org.example.lookinsure.domain.Review;
import org.example.lookinsure.enumaration.ReviewStatus;
import org.example.lookinsure.enumaration.ReviewVisibility;
import org.example.lookinsure.exception.CommentDisabledException;
import org.example.lookinsure.exception.NotFoundException;
import org.example.lookinsure.exception.ProductNotPurchasedException;
import org.example.lookinsure.exception.RatingDisabledException;
import org.example.lookinsure.mapper.ReviewMapper;
import org.example.lookinsure.repository.ReviewRepository;
import org.example.lookinsure.service.ProductConfigService;
import org.example.lookinsure.service.ReviewService;
import org.example.lookinsure.service.constant.Constant;
import org.example.lookinsure.service.dto.CommentDTO;
import org.example.lookinsure.service.dto.ProductReviewDTO;
import org.example.lookinsure.service.dto.ReviewDTO;
import org.example.lookinsure.service.request.ProductReviewRequest;
import org.example.lookinsure.service.request.UpdateReviewStatusRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository repository;
    private final ReviewMapper mapper;
    private final ReviewProperties reviewProps;
    private final ProductConfigService productConfigService;


    @Override
    public List<ReviewDTO> findByStatus(Long productId, ReviewStatus status) {
        return mapper.toDTOList(repository.findByProductIdAndStatus(productId, status));
    }

    @Override
    public void updateReviewStatus(UpdateReviewStatusRequest request) {
        Review review = repository.findById(request.getReviewId())
                .orElseThrow(() -> new NotFoundException(Constant.ExceptionMessage.REVIEW_NOT_FOUND));
        review.setStatus(request.getStatus());
        repository.save(review);
    }

    @Override
    public ProductReviewDTO getProductReviewData(Long productId) {
        List<Review> approvedReviews = repository.findReviewsByProductId(productId, ReviewStatus.APPROVED);

        if (ObjectUtils.isEmpty(approvedReviews))
            return null;

        List<CommentDTO> commentDTOList = this.getComments(approvedReviews);
        Double averageRate = this.calculateAverageRating(approvedReviews);
        return mapper.toProductReviewDTOList(productId, commentDTOList, averageRate, approvedReviews.size());
    }

    @Override
    public void add(ProductReviewRequest request) {
        ProductConfig productConfig = productConfigService.getConfigByProductId(request.getProductId());
        this.validateProductConfig(productConfig, request);
        repository.save(mapper.toEntity(request));
    }

    private void validateProductConfig(ProductConfig config, ProductReviewRequest request) {
        if (ReviewVisibility.BUYERS.equals(config))
            throw new ProductNotPurchasedException();
        if (StringUtils.hasText(request.getComment()) && !config.getCommentEnabled())
            throw new CommentDisabledException();
        if (Objects.nonNull(request.getRate()) && !config.getRatingEnabled())
            throw new RatingDisabledException();
    }

    private Double calculateAverageRating(List<Review> reviews) {
        return reviews.stream()
                .mapToDouble(Review::getRate)
                .average()
                .orElse(0.0);
    }

    private List<CommentDTO> getComments(List<Review> reviews) {
        Integer limit = reviewProps.getLastVisibleCommentsThreshold();
        List<Review> reviewSubList = reviews.subList(0, Math.min(limit, reviews.size()));
        return mapper.toCommentDTOList(reviewSubList);
    }
}
