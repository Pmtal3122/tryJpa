package com.piyush.tryJpa.tryJpa.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TryAspect {

    private static final Logger log = LoggerFactory.getLogger(TryAspect.class);

    @Before("execution(* com.piyush.tryJpa.tryJpa.controllers.*.*(..))")
    public void log() {
        log.info("Logging from Aspect");
    }
}
