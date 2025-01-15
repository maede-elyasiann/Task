package org.example.lookinsure.service.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ProductRequest {

    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private Long providerId;
}
