package com.example.ms.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.ms.curencyexchangeservice.CurrencyExchangeController;

@RestController
public class CurrencyConversionController {
	private final Logger LOGGER = LoggerFactory.getLogger(CurrencyConversionController.class);
	@Autowired
	private Environment env;

	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	@GetMapping("/currency-converter/from/{from}/to/{to}/amount/{amount}")
	public CurrencyConversionResult convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal amount) {
		final Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", "USD");
		uriVariables.put("to", "INR");
		ResponseEntity<CurrencyConversionResult> response = new RestTemplate().getForEntity(
				"http://localhost:8001/currency-exchange/from/{from}/to/{to}", CurrencyConversionResult.class,
				uriVariables);

		CurrencyConversionResult result = response.getBody();
		result.setResultAmount(amount.multiply(result.getConversionMultiple()));
		return result;
	}

	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/amount/{amount}")
	public CurrencyConversionResult convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal amount) {

		CurrencyConversionResult result = proxy.getExchangeValue(from, to);
		result.setResultAmount(amount.multiply(result.getConversionMultiple()));

		LOGGER.info("{}", result);
		return result;
	}
}
