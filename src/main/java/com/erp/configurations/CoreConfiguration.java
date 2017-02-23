package com.erp.configurations;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by DANG on 22-Feb-17.
 */

@EnableAutoConfiguration
@Configuration
public class CoreConfiguration extends WebMvcConfigurerAdapter{
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS", "PATCH")
                .allowedOrigins("*");
    }

}
