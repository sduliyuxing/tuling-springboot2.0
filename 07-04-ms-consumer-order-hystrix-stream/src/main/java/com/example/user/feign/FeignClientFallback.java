package com.example.user.feign;

import com.example.user.entity.User;
import org.springframework.stereotype.Component;

/**
 * 回退类FeignClientFallback需实现Feign Client接口
 * FeignClientFallback也可以是public class，没有区别
 */
@Component
public class FeignClientFallback implements UserFeignClient {
    @Override
    public User findById(Long id) {
        // 降级方法名必须和源方法名一样
        User user = new User();
        user.setId(-1L);
        user.setUsername("默认用户");
        return user;
    }
}