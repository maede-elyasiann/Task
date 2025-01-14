package org.example.lookinsure.service.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class CommentDTO {

    private Long customerId;

    private String comment;

    private Double rate;

    private LocalDateTime createdAt;
}
