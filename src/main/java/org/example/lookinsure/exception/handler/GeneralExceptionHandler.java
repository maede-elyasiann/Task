package org.example.lookinsure.exception.handler;

import lombok.RequiredArgsConstructor;
import org.example.lookinsure.exception.BaseException;
import org.example.lookinsure.service.response.ApiResponse;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Locale;
import java.util.Objects;

@ControllerAdvice
@Order
@RequiredArgsConstructor
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler({BaseException.class})
    public ResponseEntity<ApiResponse> handleBaseException(BaseException e) {
        Locale locale = LocaleContextHolder.getLocale();
        ApiResponse response = new ApiResponse(
                messageSource.getMessage(String.valueOf(e.getCode()), null, locale),
                StringUtils.hasText(e.getDescriptionKey()) ? this.getMessage(e.getDescriptionKey())  : "Error!",
                e.getHttpCode()
        );
        return new ResponseEntity<>(response, HttpStatus.valueOf(e.getHttpCode()));

    }

    private String getMessage(String key){
       return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
    }
}
