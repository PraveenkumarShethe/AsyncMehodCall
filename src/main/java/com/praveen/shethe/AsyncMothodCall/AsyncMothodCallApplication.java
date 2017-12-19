package com.praveen.shethe.AsyncMothodCall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableAsync
public class AsyncMothodCallApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsyncMothodCallApplication.class, args);
    }
}
