package org.example.lookinsure.repository;

import org.example.lookinsure.domain.Review;
import org.example.lookinsure.enumaration.ReviewStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByProductIdAndStatus(Long productId, ReviewStatus reviewStatus);

    @Query("""
            SELECT r FROM Review r WHERE r.productId = :productId
             AND r.status = :status 
             ORDER BY r.createdAt DESC
            """)
    List<Review> findReviewsByProductId(@Param("productId") Long productId,
                                        @Param(("status")) ReviewStatus status);

}
