package me.bbnag.bangspringbootapppractice;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

@SpringBootApplication
public class BangSpringBootAppPracticeApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(BangSpringBootAppPracticeApplication.class);
        app.setBanner(new Banner() {
            @Override
            public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
                out.println("=================");
                out.println("Bang");
                out.println("=================");
            }
        });
        app.setWebApplicationType(WebApplicationType.SERVLET);
        //app.setBannerMode(Banner.Mode.OFF);
        //app.addListeners(new SampleListener());
        app.run(args);
    }

}
