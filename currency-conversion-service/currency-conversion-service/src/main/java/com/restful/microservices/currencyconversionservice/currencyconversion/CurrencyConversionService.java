package com.restful.microservices.currencyconversionservice.currencyconversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@Service
public class CurrencyConversionService {

    private final CurrencyExchangeProxy currencyExchangeProxy;

    @Autowired
    public CurrencyConversionService (CurrencyExchangeProxy currencyExchangeProxy) {
        this.currencyExchangeProxy = currencyExchangeProxy;
    }

    public CurrencyConversion calculateCurrencyConversion (
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity) {

        CurrencyConversion currencyConversion = currencyExchangeProxy.retrieveExchangeValue(
                from, to
        );

        currencyConversion.setQuantity(quantity);

        currencyConversion.setTotalCalculatedAmount(
                quantity.multiply(currencyConversion.getConversionRate())
        );

        return currencyConversion;
    }

}
