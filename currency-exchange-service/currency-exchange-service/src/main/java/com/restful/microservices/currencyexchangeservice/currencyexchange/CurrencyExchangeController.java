package com.restful.microservices.currencyexchangeservice.currencyexchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("currency-exchange")
public class CurrencyExchangeController {
    private final Environment environment;
    private final CurrencyExchangeService currencyExchangeService;

    @Autowired
    public CurrencyExchangeController (Environment environment, CurrencyExchangeService currencyExchangeService) {
        this.environment = environment;
        this.currencyExchangeService = currencyExchangeService;
    }

    @GetMapping
    public List<CurrencyExchange> retrieveAllExchangeValue () {
        return currencyExchangeService.getAllCurrencyExchangeValue();
    }

    @GetMapping("from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue (
            @PathVariable String from, @PathVariable String to) {

        CurrencyExchange currencyExchange = currencyExchangeService.getCurrencyExchangeValue(from, to);
        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);

        return currencyExchange;
    }
}
