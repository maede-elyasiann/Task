package org.example.lookinsure.service.request;

import lombok.Data;
import org.example.lookinsure.enumaration.ReviewStatus;

@Data
public class UpdateReviewStatusRequest {

    private Long reviewId;
    private ReviewStatus status;
}
