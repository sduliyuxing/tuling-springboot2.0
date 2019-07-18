package com.biege.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>Title: WebMvcConfig </p>
 * <p>Description:  </p>
 * <p>Company: http://www.biege.com/ </p>
 * <p>Author: 别圣平 </p>
 * <p>CreateTime: 2019-06-24 07:20 </p>
 * <p>Version: 1.0 </p>
 */
// public class WebMvcConfig extends WebMvcConfigurerAdapter {  已过期
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/testmvc").setViewName("/abc");
    }

}
