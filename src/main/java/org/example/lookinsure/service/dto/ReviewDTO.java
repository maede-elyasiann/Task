package org.example.lookinsure.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;
import org.example.lookinsure.enumaration.ReviewStatus;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@AllArgsConstructor
public class ReviewDTO {

    private Long productId;

    private Long customerId;

    private String comment;

    private Double rate;

    private ReviewStatus status;

    private LocalDateTime createdAt;
}
