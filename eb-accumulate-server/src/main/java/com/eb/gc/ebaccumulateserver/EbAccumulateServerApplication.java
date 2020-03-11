package com.eb.gc.ebaccumulateserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EbAccumulateServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbAccumulateServerApplication.class, args);
    }

}
