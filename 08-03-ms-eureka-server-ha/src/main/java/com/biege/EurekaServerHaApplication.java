package com.biege;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerHaApplication {

    // eureka 高可用HA
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerHaApplication.class, args);
    }

    /*
        测试过程:
            mvn clean install  连接会出错,不用管
            target文件夹下,cmd,  java -jar 08-03-ms-eureka-server-ha-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer1/2/3
            启动三个.
            再启动 08-01-ms-provider-user 项目.可以注册到3个eureka中
            更改配置
                  defaultZone: http://biege:123@127.0.0.1:8761/eureka,http://biege:123@127.0.0.1:8762/eureka,http://biege:123@127.0.0.1:8763/eureka
            为只注册一台eureka:
                  defaultZone: http://biege:123@127.0.0.1:8761/eureka
            再启动 08-01-ms-provider-user 项目.还是可以注册到3个eureka中,实现高可用.
     */

    @EnableWebSecurity
    static class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().ignoringAntMatchers("/eureka/**");
            super.configure(http);
        }
    }


}
