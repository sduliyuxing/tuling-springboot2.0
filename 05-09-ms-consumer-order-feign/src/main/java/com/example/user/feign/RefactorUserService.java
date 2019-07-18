package com.example.user.feign;

import com.example.service.UserService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "microservice-provider-user")
public interface RefactorUserService extends UserService {
}