package org.example.lookinsure.service.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;
import org.example.lookinsure.enumaration.ReviewVisibility;
import org.example.lookinsure.service.dto.CommentDTO;

import java.util.List;

@Data
@Accessors(chain = true)
public class ProductResponse {

    private Long id;
    private String name;
    private String description;
    private String provider;
    private Integer price;
    private List<CommentDTO> comments;
    private Double averageRate;
    private Integer totalReviews;
    @JsonIgnore
    private Boolean isCommentEnabled;
    @JsonIgnore
    private Boolean isRatingEnabled;
    @JsonIgnore
    private ReviewVisibility reviewVisibility;
}
