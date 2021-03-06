package com.mt.metro.aop;

import com.mt.metro.annotation.CacheLock;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.UUID;

@Aspect
@Component
public class LockCacheAspect {

    /** lua */
    private static final String RELEASE_LOCK_LUA_SCRIPT = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    // 增强带有CacheLock注解的方法
    @Pointcut("@annotation(com.mt.metro.annotation.CacheLock)")
    public void pointCut() {
    }

    @Around(value = "pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        // 可以根据业务获取用户唯一的个人信息，例如手机号码
        String phone = "12312";

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        CacheLock cacheLock = method.getAnnotation(CacheLock.class);
        String prefix = cacheLock.prefix();
        if (StringUtils.isEmpty(prefix)) {
            throw new RuntimeException("CacheLock prefix can't be null");
        }
        // 拼接 key
        String delimiter = cacheLock.delimiter();
        StringBuilder sb = new StringBuilder();
        sb.append(prefix).append(delimiter).append(phone);
        String lockKey = sb.toString();
        String uuid = UUID.randomUUID().toString();

        try {
            System.out.println("????");
            //获取锁
            //这个函数不存在，可能版本问题，不整合redission可以使用
            // boolean success = redisTemplate.opsForValue().setIfAbsent(lockKey, "dsf"+uuid, cacheLock.expire(), cacheLock.timeUnit());
            // if (!success) {
            //     throw new RuntimeException("请勿重复提交");
            // }


            Object object = redisTemplate.opsForValue().get(lockKey);
            if ( object!= null) {
                throw new RuntimeException("请勿重复提交");
            }else {
                redisTemplate.opsForValue().set(lockKey, "dsf"+uuid, cacheLock.expire(), cacheLock.timeUnit());
            }


            Object result = joinPoint.proceed();
            return result;
        }

        finally {
            // 最后记得释放锁
            DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>(RELEASE_LOCK_LUA_SCRIPT, Long.class);
            Long result = (long)redisTemplate.execute(redisScript, Collections.singletonList(lockKey), uuid);
        }

    }
}
