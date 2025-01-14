package org.example.lookinsure.api;

import lombok.AllArgsConstructor;
import org.example.lookinsure.enumaration.ReviewStatus;
import org.example.lookinsure.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/admin/review")
@AllArgsConstructor
public class AdminReviewController {

    private final ReviewService reviewService;

    @PutMapping("/{productId}")
    public ResponseEntity<String> findByProductAndStatus(@PathVariable Long productId,
                                                     @RequestParam ReviewStatus status) {
        reviewService.findByStatus(productId, status);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReviewStatus(@PathVariable Long reviewId,
                                                     @RequestParam ReviewStatus status) {
        reviewService.updateReviewStatus(reviewId, status);
        return ResponseEntity.ok().build();
    }
}
