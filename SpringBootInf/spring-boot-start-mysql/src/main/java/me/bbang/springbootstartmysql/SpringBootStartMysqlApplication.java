package me.bbang.springbootstartmysql;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

@SpringBootApplication
public class SpringBootStartMysqlApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringBootStartMysqlApplication.class);
        app.setBanner(new Banner() {
            @Override
            public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
                System.out.println("==============================");
                System.out.println("Bang Start MySQL");
                System.out.println("==============================");
            }
        });
        app.run(args);
    }
}
