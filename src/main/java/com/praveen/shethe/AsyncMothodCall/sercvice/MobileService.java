package com.praveen.shethe.AsyncMothodCall.sercvice;

import com.praveen.shethe.AsyncMothodCall.model.Mobile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class MobileService {
    private static final Logger logger = LoggerFactory.getLogger(MobileService.class);

    private final RestTemplate restTemplate;

    public MobileService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


    @Async
    public CompletableFuture<Mobile> findUser(String user) throws InterruptedException {
        logger.info("Looking up " + user);
        String url = String.format("https://api.github.com/users/%s", user);
        Mobile results = restTemplate.getForObject(url, Mobile.class);
        // Artificial delay of 1s for demonstration purposes
        Thread.sleep(2000L);
        return CompletableFuture.completedFuture(results);
    }
}


