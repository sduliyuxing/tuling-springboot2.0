package com.biege;

import com.biege.demo.rabbitmq.Sender;
import com.biege.rabbitmq.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = VipApplication.class)
public class RabbitmqTest {
    @Autowired
    private Sender sender;

    @Test
    public void testRabbitmq() throws Exception {
        sender.send();
    }

}