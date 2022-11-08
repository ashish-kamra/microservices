package com.restful.microservices.currencyconversionservice.currencyconversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("currency-conversion")
public class CurrencyConversionController {

    private final CurrencyConversionService currencyConversionService;

    @Autowired
    public CurrencyConversionController (CurrencyConversionService currencyConversionService) {
        this.currencyConversionService = currencyConversionService;
    }

    @GetMapping("from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion (
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity) {

        return currencyConversionService.calculateCurrencyConversion(
                from, to, quantity
        );
    }
}

