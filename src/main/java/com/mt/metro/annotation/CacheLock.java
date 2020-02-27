package com.mt.metro.annotation;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * 自定义注解：分布式锁
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface CacheLock {

    /**
     * key前缀
     */
    String prefix() default "";

    /**
     * 过期秒数,默认为5秒
     */
    int expire() default 5;

    /**
     * 超时时间单位，默认为秒
     */
    TimeUnit timeUnit() default TimeUnit.SECONDS;

    /**
     * Key的分隔符（默认 :）
     */
    String delimiter() default ":";
}