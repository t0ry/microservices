package com.example.ms.currencyconversionservice;

import java.math.BigDecimal;


public class CurrencyConversionResult {
	String from;
	String to;
	BigDecimal conversionMultiple;
	BigDecimal amount;
	BigDecimal resultAmount;
	
	int port;

	public CurrencyConversionResult(String from, String to, BigDecimal conversionMultiple, BigDecimal amount,
			BigDecimal resultAmount, int port) {
		super();
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.amount = amount;
		this.resultAmount = resultAmount;
		this.port = port;
	}

	public CurrencyConversionResult() {
		super();
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getResultAmount() {
		return resultAmount;
	}

	public void setResultAmount(BigDecimal resultAmount) {
		this.resultAmount = resultAmount;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	

}
