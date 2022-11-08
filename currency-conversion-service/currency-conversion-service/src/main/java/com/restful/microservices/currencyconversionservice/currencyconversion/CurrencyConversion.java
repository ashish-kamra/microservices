package com.restful.microservices.currencyconversionservice.currencyconversion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConversion {
    private Long id;
    private String fromCurrency;
    private String toCurrency;
    private BigDecimal quantity;
    private BigDecimal conversionRate;
    private BigDecimal totalCalculatedAmount;
    private String environment;
}
