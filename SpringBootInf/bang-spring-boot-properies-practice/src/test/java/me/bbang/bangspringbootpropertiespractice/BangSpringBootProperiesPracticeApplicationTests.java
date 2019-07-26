package me.bbang.bangspringbootpropertiespractice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BangSpringBootProperiesPracticeApplicationTests {


    @Autowired
    Environment environment;

    @Test
    public void contextLoads() {
        String property = environment.getProperty("kihyun.name");
        if (property.equals("bang"))
            System.out.println(property);
    }

}
