package me.bbang.springbootstartmvc2;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

@SpringBootApplication
public class SpringBootStartMvc2Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringBootStartMvc2Application.class);
        app.setBanner(new Banner() {
            @Override
            public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
                System.out.println("=============================");
                System.out.println("Bang MVC Start!!!!!!!!!!!!!!");
                System.out.println("=============================");
            }
        });
        app.run(args);
    }
}
