package com.kodilla.patterns2.facade.dao;

import com.kodilla.patterns2.facade.api.OrderDto;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FacadeWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(FacadeWatcher.class);

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..)) && target(object) && args(orderDto, userId)")
    public void showBeforeLog(Object object, OrderDto orderDto, Long userId) {
        LOGGER.info("The 'processOrder' method has started working");
        LOGGER.info("Class: " + object.getClass().getName() + ", FirstArg: " + orderDto + ", SecondArg: " + userId);
    }
    @After("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void showAfterLog() {
        LOGGER.info("The 'processOrder' method has ended working");
    }
}
