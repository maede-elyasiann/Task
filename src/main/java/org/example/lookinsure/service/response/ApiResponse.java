package org.example.lookinsure.service.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse<T>{

    @JsonProperty("status_code")
    private String statusCode;
    private String message;
    private int httpCode;

}