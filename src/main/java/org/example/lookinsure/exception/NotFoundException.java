package org.example.lookinsure.exception;

import org.example.lookinsure.service.constant.Constant;
import org.springframework.http.HttpStatus;

public class NotFoundException extends BaseException {

    private String desc;

    public NotFoundException(String desc) {
        super(desc);
    }

    @Override
    public String getCode() {
        return Constant.ExceptionCode.NOT_FOUND;
    }

    @Override
    public String getDescriptionKey() {
        return this.desc;
    }

    @Override
    public int getHttpCode() {
        return HttpStatus.NOT_FOUND.value();
    }
}
