package com.example.ms.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//@FeignClient(name="curency-exchange-service")
@FeignClient(name="curency-exchange-service")
@RibbonClient(name="zuul-gateway")
public interface CurrencyExchangeServiceProxy {
	//@GetMapping("/{service-name}/{api-uri}")
	@GetMapping("/curency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionResult getExchangeValue(@PathVariable String from, @PathVariable String to);
}
