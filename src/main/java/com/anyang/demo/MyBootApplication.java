package com.anyang.demo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;



@ServletComponentScan(basePackages = {"com.anyang.demo"})
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class MyBootApplication {

    public static void main(String[] args) {
        String PROTOCOL_HANDLER = "java.protocol.handler.pkgs";
        String handlers = System.getProperty(PROTOCOL_HANDLER, "");
        try {
            System.clearProperty(PROTOCOL_HANDLER);
            try {
                URL url = new URL("jar:file:context.jar!/");
                URLConnection connection = url.openConnection();
                System.out.println(connection.getClass().getName());
            }
            catch (Exception ex) {
            }
        }
        finally {
            if (handlers == null) {
                System.clearProperty(PROTOCOL_HANDLER);
            }
            else {
                System.setProperty(PROTOCOL_HANDLER, handlers);
            }
        }



        SpringApplication springApplication = new SpringApplication(MyBootApplication.class);
        // 关闭条幅打印
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);


    }
}
