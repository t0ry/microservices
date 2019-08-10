package com.example.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.microservices.limitsservice.Configuration;
import com.example.microservices.limitsservice.bean.LimitConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitsConfigurationController {

  @Autowired
  private Configuration configuration;

  @GetMapping("/limits")
  
  public LimitConfiguration retrieveLimitsFormConfigurations() {
    return new LimitConfiguration(configuration.getMin(), configuration.getMax());
  }
  
  @GetMapping("/fault")
  @HystrixCommand(fallbackMethod = "faulbackRetriveConf") //if this method fails -- use default one with name "faulbackRetriveConf"
  public LimitConfiguration retrieveConfigurations() {
    throw new RuntimeException("OOOOOOPS!");
  }
  
  public LimitConfiguration faulbackRetriveConf() {
	    return new LimitConfiguration(0, 999);
	  }

}
