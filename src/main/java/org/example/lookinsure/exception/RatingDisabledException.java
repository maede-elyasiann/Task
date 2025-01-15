package org.example.lookinsure.exception;

import org.example.lookinsure.service.constant.Constant;
import org.springframework.http.HttpStatus;

public class RatingDisabledException extends BaseException{

    private static final String DESC = Constant.ExceptionMessage.RATING_DISABLED;

    public RatingDisabledException() {
        super(DESC);
    }

    @Override
    public String getCode() {
        return Constant.ExceptionCode.DISABLED;
    }

    @Override
    public String getDescriptionKey() {
        return DESC;
    }

    @Override
    public int getHttpCode() {
        return HttpStatus.NOT_ACCEPTABLE.value();
    }
}
