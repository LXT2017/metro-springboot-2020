package com.mt.metro.aop;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class VisitLogAop {

    private final Logger logger = LogManager.getLogger(VisitLogAop.class);


    //切入点
    @Pointcut("@annotation(com.mt.metro.annotation.VisitLog)")
    public void visitLogPointCut(){}

    @Before(value="visitLogPointCut()")
    public  void beforeVisitLog() {
        logger.debug("Debugging log");
        logger.info("Info log");
        logger.warn("Hey, This is a warning!");
        logger.error("Oops! We have an Error. OK");
    }




}
