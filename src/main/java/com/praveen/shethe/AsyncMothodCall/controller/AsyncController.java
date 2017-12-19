package com.praveen.shethe.AsyncMothodCall.controller;

import com.praveen.shethe.AsyncMothodCall.model.Mobile;
import com.praveen.shethe.AsyncMothodCall.sercvice.HelloService;
import com.praveen.shethe.AsyncMothodCall.sercvice.MobileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;


@RestController
@RequestMapping(value = "/async", produces = MediaType.APPLICATION_JSON_VALUE)
public class AsyncController {

    private Logger logger = LoggerFactory.getLogger(AsyncController.class);

    @Autowired
    private MobileService mobileService;
    @Autowired
    private HelloService helloService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void insertNewMobile(@RequestBody Mobile book) throws InterruptedException {
        mobileService.findUser(book.getMobileName());
    }

    @RequestMapping("/helloAsync")
    public Callable<String> sayHelloAsync() {
        logger.info("Entering controller");
        Callable<String> asyncTask = new Callable<String>() {

            @Override
            public String call() throws Exception {
                return helloService.doSlowWorkHere();
            }
        };
        logger.info("Leaving  controller");
        return asyncTask;
    }
}

