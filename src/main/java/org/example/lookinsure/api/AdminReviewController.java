package org.example.lookinsure.api;

import lombok.AllArgsConstructor;
import org.example.lookinsure.enumaration.ReviewStatus;
import org.example.lookinsure.service.ReviewService;
import org.example.lookinsure.service.request.UpdateReviewStatusRequest;
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

    @PutMapping
    public ResponseEntity<String> updateReviewStatus(@RequestBody UpdateReviewStatusRequest request) {
        reviewService.updateReviewStatus(request);
        return ResponseEntity.ok().build();
    }
}
