package me.bbang.databinding.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    //#을 사용하는 것 -> 표현식
    @Value("#{1 + 1}")
    int value;

    @Value("#{'hello' + 'world'}")
    String greeting;

    @Value("#{1 eq 1}")
    boolean trueOrFalse;

    @Value("Hello")
    String hello;

    //property 사용 방법
    @Value("${my.value}")
    int myValue;

    //SpEL 안에 property 사용 방법
    @Value("#{${my.value} eq 100}")
    boolean myValue100;

    //Bean으로 등록된 class 사용가능
    @Value("#{sample.data}")
    int sampleData;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("=======================");
        System.out.println(value);
        System.out.println(greeting);
        System.out.println(trueOrFalse);
        System.out.println(hello);
        System.out.println(myValue);
        System.out.println(myValue100);
        System.out.println(sampleData);

        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("1 + 200");
        Integer num = expression.getValue(Integer.class);
        System.out.println(num);
    }

}
