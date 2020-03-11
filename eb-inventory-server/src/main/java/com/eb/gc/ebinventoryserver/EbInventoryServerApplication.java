package com.eb.gc.ebinventoryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EbInventoryServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbInventoryServerApplication.class, args);
    }

}
