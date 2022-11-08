package com.restful.microservices.currencyexchangeservice.currencyexchange;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
    CurrencyExchange findByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency);
}
