package org.example.lookinsure.config;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Data
@Accessors(chain = true)
@Component
@RefreshScope
@ConfigurationProperties(prefix = "review.config")
public class ReviewProperties {

    private Integer lastVisibleCommentsThreshold;
}
