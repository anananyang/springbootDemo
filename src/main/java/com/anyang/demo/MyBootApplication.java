package com.anyang.demo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


@ServletComponentScan(basePackages = {"com.anyang.demo"})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MyBootApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(MyBootApplication.class);
        // 关闭条幅打印
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }
}
