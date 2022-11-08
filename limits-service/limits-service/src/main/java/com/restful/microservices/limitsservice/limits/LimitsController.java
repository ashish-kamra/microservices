package com.restful.microservices.limitsservice.limits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/limits")
public class LimitsController {
    @Autowired
    private LimitsConfiguration limitsConfiguration;

    public LimitsController (LimitsConfiguration limitsConfiguration) {
        this.limitsConfiguration = limitsConfiguration;
    }

    @GetMapping
    public Limits retrieveLimits() {
        return new Limits(limitsConfiguration.getMinimum(),
                limitsConfiguration.getMaximum());
    }

}
