package com.anyang.demo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MyBootApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(MyBootApplication.class);
        // 关闭条幅打印
//        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }

}
