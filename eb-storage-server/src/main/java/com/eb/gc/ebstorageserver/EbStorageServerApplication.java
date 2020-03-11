package com.eb.gc.ebstorageserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EbStorageServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbStorageServerApplication.class, args);
    }

}
