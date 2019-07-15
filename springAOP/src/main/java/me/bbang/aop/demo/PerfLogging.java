package me.bbang.aop.demo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//Retention : 이 Annotation을 어디까지 적용할 것인가
@Retention(RetentionPolicy.CLASS)
public @interface PerfLogging {

}
