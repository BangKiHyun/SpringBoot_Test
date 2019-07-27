package me.bbang.bangspringbootprofile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleRunner implements ApplicationRunner {

    @Autowired
    private String hello;

    @Autowired
    private BangProperties bangProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("========================-");
        System.out.println(hello);
        System.out.println(bangProperties.getName());
        System.out.println(bangProperties.getFullName());
        System.out.println("========================-");
    }
}
