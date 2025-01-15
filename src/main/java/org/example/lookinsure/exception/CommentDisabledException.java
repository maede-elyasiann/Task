package org.example.lookinsure.exception;

import org.example.lookinsure.service.constant.Constant;
import org.springframework.http.HttpStatus;

public class CommentDisabledException extends BaseException {

    private static final String DESC = Constant.ExceptionMessage.COMMENT_DISABLED;

    public CommentDisabledException() {
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
