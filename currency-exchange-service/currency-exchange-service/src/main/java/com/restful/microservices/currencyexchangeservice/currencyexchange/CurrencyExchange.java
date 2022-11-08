package com.restful.microservices.currencyexchangeservice.currencyexchange;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
@Data
@NoArgsConstructor
@Entity
@Table(name = "currency_exchange")
public class CurrencyExchange {
    @Id
    @SequenceGenerator(
            name = "exchange_sequence",
            sequenceName = "exchange_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "exchange_sequence"
    )
    private Long id;
    private String fromCurrency;
    private String toCurrency;
    private BigDecimal conversionRate;
    private String environment;

    public CurrencyExchange (String fromCurrency, String toCurrency, BigDecimal conversionRate) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.conversionRate = conversionRate;
    }
}
