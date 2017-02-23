package com.erp.configurations;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by DANG on 22-Feb-17.
 */
public class WebMvcConfiguration extends WebMvcConfigurerAdapter  {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("file:/opt/project/default/images/");
    }

}
