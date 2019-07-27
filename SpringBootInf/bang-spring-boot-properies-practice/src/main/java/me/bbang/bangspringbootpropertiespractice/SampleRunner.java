package me.bbang.bangspringbootpropertiespractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleRunner implements ApplicationRunner {

/*    @Value("${bang.name}")
    private String name;

    @Value("${bang.age}")
    private int age;

    @Value("${bang.fullName")
    private String fullName;*/

    @Autowired
    SampleProperties sampleProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("=======================");
        System.out.println(sampleProperties.getName());
        System.out.println(sampleProperties.getAge());
        System.out.println(sampleProperties.getFullName());
/*        System.out.println(name);
        System.out.println(age);
        System.out.println(fullName);*/
        System.out.println(sampleProperties.getSessionTimeout());
        System.out.println("=======================");
    }
}
