package com.biege.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <p>Title: CommonConfig </p>
 * <p>Description:  </p>
 * <p>Company: http://www.biege.com/ </p>
 * <p>Author: 别圣平 </p>
 * <p>CreateTime: 2019-06-24 04:56 </p>
 * <p>Version: 1.0 </p>
 */
@Configuration
public class CommonConfig {

    @Bean
    public RestTemplate restTemplatestTemplate(){
        return new RestTemplate();
    }
}
