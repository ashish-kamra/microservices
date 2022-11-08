package com.restful.microservices.limitsservice.limits;

import lombok.Builder;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties("limits-service")
public class LimitsConfiguration {
    private long minimum;
    private long maximum;
}
