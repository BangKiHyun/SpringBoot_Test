package me.bbang.aop.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerfAspect {

    //Around안에 Pointcut을 정의
    //@Around("execution(* me.bbang..*.EventService.*(..)))") //EventService가 적용되는 곳에 사용
    @Around("@annotation(PerfLogging)") //()안에있는 annotation이 적용된 곳에 사용
    public Object logPerf(ProceedingJoinPoint pjp) throws Throwable{
        long begin = System.currentTimeMillis();
        Object retVal = pjp.proceed();
        System.out.println(System.currentTimeMillis() - begin);
        return retVal;
    }

    //()안의 class 실행 이전에 method를 실행하여라
    @Before("bean(simpleEventService)")
    public void hello(){
        System.out.println("hello");
        System.out.println("test");
    }
}
