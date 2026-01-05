package com.naver.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class TimerAspect {

    @Around("@annotation(com.naver.aspect.Timer)") // @Timer가 붙은 곳에 적용
    public Object measureTime(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = joinPoint.proceed(); // 원래 메소드 실행

        stopWatch.stop();
        System.out.println(joinPoint.getSignature().getName() + " 실행 시간: " + stopWatch.getTotalTimeMillis() + "ms");

        return result;
    }
}