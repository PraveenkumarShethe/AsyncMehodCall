package com.praveen.shethe.AsyncMothodCall.sercvice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class HelloService {

    private Logger logger = LoggerFactory.getLogger(HelloService.class);

    @Async
    public String doSlowWorkHere() {

        logger.info("Start Slow work");
        logger.info("");
        logger.info("");
        logger.info("");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("");
        logger.info("");
        logger.info("");
        logger.info("Stop Slow work");
        return "index";

    }
}
