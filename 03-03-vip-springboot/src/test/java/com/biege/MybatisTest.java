package com.biege;

import com.biege.bean.User;
import com.biege.demo.bean.User;
import com.biege.demo.mapper.UserMapper;
import com.biege.mapper.UserMapper;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = VipApplication .class)
public class MybatisTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DataSource dataSource;
    @Test
    public void testInsert() throws Exception {
        DataSource dataSource1 = this.dataSource;
        int num = userMapper.insert("zhangsan111", 20, "长沙", "13100000000");
        TestCase.assertEquals(num, 1);
    }

    @Test
    public void testFindById() throws Exception {
        User u = userMapper.findById(2);
        TestCase.assertNotNull(u);
        System.out.println(u.getName());
    }

}