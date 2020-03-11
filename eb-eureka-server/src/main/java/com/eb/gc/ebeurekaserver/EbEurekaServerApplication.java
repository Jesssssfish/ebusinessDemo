package com.eb.gc.ebeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EbEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbEurekaServerApplication.class, args);
    }

}
