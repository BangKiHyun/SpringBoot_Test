package me.bbang.bangspringbootpropertiespractice;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

@SpringBootApplication
public class BangSpringBootPropertiesPracticeApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(BangSpringBootPropertiesPracticeApplication.class);
        app.setBanner(new Banner() {
            @Override
            public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
                System.out.println("========================");
                System.out.println("Bang Spring Boot Banner");
                System.out.println("=========================");
            }
        });
        app.run(args);
    }
}
