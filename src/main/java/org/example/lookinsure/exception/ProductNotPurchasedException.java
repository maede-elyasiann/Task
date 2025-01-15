package org.example.lookinsure.exception;

import org.example.lookinsure.service.constant.Constant;
import org.springframework.http.HttpStatus;

public class ProductNotPurchasedException extends BaseException{

    private static final String DESC = Constant.ExceptionMessage.NOT_PURCHASED;

    public ProductNotPurchasedException() {
        super(DESC);
    }

    @Override
    public String getCode() {
        return Constant.ExceptionCode.NOT_PURCHASED;
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
