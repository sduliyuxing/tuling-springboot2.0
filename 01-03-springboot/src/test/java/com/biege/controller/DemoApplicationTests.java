package com.biege.controller;

import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;



@Ignore
@SpringBootTest(classes=HelloController .class)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class DemoApplicationTests {

    @Autowired
    private HelloController controller ;

    @Test
    public void testHome(){
        TestCase.assertEquals("Hello World!", controller.home());
        System.out.println(controller.home());
    }

}