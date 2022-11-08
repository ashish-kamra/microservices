package com.restful.microservices.currencyexchangeservice.currencyexchange;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CurrencyExchangeService {
    private final CurrencyExchangeRepository currencyExchangeRepository;

    @Autowired
    public CurrencyExchangeService (CurrencyExchangeRepository currencyExchangeRepository) {
        this.currencyExchangeRepository = currencyExchangeRepository;
    }

    public List<CurrencyExchange> getAllCurrencyExchangeValue () {
        return currencyExchangeRepository.findAll();
    }

    public CurrencyExchange getCurrencyExchangeValue (String fromCurrency, String toCurrency) {
       return currencyExchangeRepository.findByFromCurrencyAndToCurrency(fromCurrency, toCurrency);
    }

}
