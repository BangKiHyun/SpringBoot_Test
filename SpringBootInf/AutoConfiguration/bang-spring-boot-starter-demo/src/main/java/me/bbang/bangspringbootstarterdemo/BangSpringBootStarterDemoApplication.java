package me.bbang.bangspringbootstarterdemo;

import me.bbang.Holoman;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BangSpringBootStarterDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BangSpringBootStarterDemoApplication.class, args);
    }

    /*@Bean
    public Holoman holoman(){
        Holoman holoman = new Holoman();
        holoman.setName("bang");
        holoman.setHowLong(60);
        return holoman;
    }*/

}
