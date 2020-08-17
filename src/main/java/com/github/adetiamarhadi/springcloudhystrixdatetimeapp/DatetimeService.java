package com.github.adetiamarhadi.springcloudhystrixdatetimeapp;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DatetimeService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "unknown")
    public String getDatetime() {
        return this.restTemplate.getForEntity("http://datetime-service/datetime", String.class).getBody();
    }

    public String unknown() {
        return "unknown";
    }
}
