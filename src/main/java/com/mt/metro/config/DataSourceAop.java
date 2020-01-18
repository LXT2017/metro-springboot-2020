package com.mt.metro.config;

import com.mt.metro.common.MultipleDataSourceHelper;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAop {
    @Before("@annotation(com.mt.metro.annotation.Slave)")
    public void readPoint(){
        MultipleDataSourceHelper.set(MultipleDataSourceHelper.SLAVE);
    }
    @Before("@annotation(com.mt.metro.annotation.Master)")
    public void writePoint(){
        MultipleDataSourceHelper.set(MultipleDataSourceHelper.MASTER);
    }
}
