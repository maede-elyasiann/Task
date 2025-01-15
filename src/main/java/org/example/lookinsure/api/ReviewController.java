package org.example.lookinsure.api;

import lombok.AllArgsConstructor;
import org.example.lookinsure.service.ReviewService;
import org.example.lookinsure.service.request.ProductReviewRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/review")
@AllArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Void> addReview(@RequestBody ProductReviewRequest request) {
        reviewService.add(request);
        return ResponseEntity.ok().build();
    }
}
