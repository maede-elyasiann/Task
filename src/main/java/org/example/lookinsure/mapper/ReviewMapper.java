package org.example.lookinsure.mapper;

import org.example.lookinsure.domain.Review;
import org.example.lookinsure.service.dto.CommentDTO;
import org.example.lookinsure.service.dto.ProductReviewDTO;
import org.example.lookinsure.service.dto.ReviewDTO;
import org.example.lookinsure.service.request.ProductReviewRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

     List<ReviewDTO> toDTOList(List<Review> reviews);

     List<CommentDTO> toCommentDTOList(List<Review> reviews);

     ProductReviewDTO toProductReviewDTOList(Long productId, List<CommentDTO> comments, Double averageRate, int totalReviews);

     Review toEntity(ProductReviewRequest request);
}
