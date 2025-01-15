package org.example.lookinsure.service.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

public class Constant {

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class ExceptionMessage {
        public static final String REVIEW_NOT_FOUND = "task.exception.review.not.found";
        public static final String PROVIDER_NOT_FOUND = "task.exception.provider.not.found";
        public static final String CONFIG_NOT_FOUND = "task.exception.product.config.not.found";
        public static final String NOT_PURCHASED = "task.exception.product.not.purchased";
        public static final String COMMENT_DISABLED= "task.exception.comment.disabled";
        public static final String RATING_DISABLED= "task.exception.rating.disabled";
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class ExceptionCode {
        public static final String NOT_FOUND = "task.exception.code.not.found";
        public static final String NOT_PURCHASED = "task.exception.code.not.purchased";
        public static final String DISABLED = "task.exception.code.disabled";
    }
}
