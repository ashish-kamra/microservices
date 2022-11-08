package com.restful.microservices.currencyexchangeservice.currencyexchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class CurrencyExchangeConfig {
    @Bean
    CommandLineRunner commandLineRunner(CurrencyExchangeRepository repository) {
        return args -> {
            CurrencyExchange USDtoINRExchange = new CurrencyExchange(
                     "USD", "INR", BigDecimal.valueOf(82)
            );
            CurrencyExchange EURtoINRExchange = new CurrencyExchange(
                    "EUR", "INR", BigDecimal.valueOf(87)
            );

            repository.saveAll(List.of(USDtoINRExchange, EURtoINRExchange));
        };
    }
}
