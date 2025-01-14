package org.example.lookinsure.api.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;
import org.example.lookinsure.enumaration.ReviewVisibility;

@Data
@Accessors(chain = true)
public class ProductConfigRequest {

    @NotNull
    private Long productId;

    @NotNull
    private ReviewVisibility reviewVisibility;

    @NotNull
    private Boolean isCommentEnabled;

    @NotNull
    private Boolean isRatingEnabled;

    @NotNull
    private Boolean isVisible;
}
