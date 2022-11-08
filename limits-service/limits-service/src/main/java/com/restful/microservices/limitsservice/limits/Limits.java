package com.restful.microservices.limitsservice.limits;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Limits {
    private long minimum;
    private long maximum;
}
