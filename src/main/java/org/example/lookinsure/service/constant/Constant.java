package org.example.lookinsure.service.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

public class Constant {

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class ExceptionMessage {
        public static final String REVIEW_NOT_FOUND = "lookinsure.exception.review.not.found";
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class ExceptionCode {
        public static final String NOT_FOUND = "lookinsure.exception.not.found";
    }
}
