package org.example.lookinsure.service.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.example.lookinsure.enumaration.ReviewVisibility;

@Data
@Accessors(chain = true)
public class ProductConfigDTO {

    private Long productId;

    private Boolean isVisible;

    private Boolean isCommentEnabled;

    private Boolean isRatingEnabled;

    private ReviewVisibility reviewVisibility;
}
