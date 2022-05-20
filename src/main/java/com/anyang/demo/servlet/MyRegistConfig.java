package com.anyang.demo.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyRegistConfig {

    @Bean
    public ServletRegistrationBean myServletRegistrationBean() {
        MyServlet myServlet = new MyServlet();
        return new ServletRegistrationBean(myServlet, "/myOne", "/myTwo");
    }

    @Bean
    public FilterRegistrationBean myFilterRegistrationBean() {
        MyFilter myFilter = new MyFilter();
        FilterRegistrationBean filterRegistrationBean =  new FilterRegistrationBean(myFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/myOne", "/myTwo"));
        return filterRegistrationBean;
    }


    @Bean
    public ServletListenerRegistrationBean myServletListenerRegistrationBean() {
        MyServletContextListener listener =  new MyServletContextListener();
        return new ServletListenerRegistrationBean(listener);
    }
}
