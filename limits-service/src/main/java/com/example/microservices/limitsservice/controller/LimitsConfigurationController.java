package com.example.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.microservices.limitsservice.Configuration;
import com.example.microservices.limitsservice.bean.LimitConfiguration;

@RestController
public class LimitsConfigurationController {

  @Autowired
  private Configuration configuration;

  @GetMapping("/limits")
  public LimitConfiguration retrieveLimitsFormConfigurations() {
    return new LimitConfiguration(configuration.getMin(), configuration.getMax());
  }

}
