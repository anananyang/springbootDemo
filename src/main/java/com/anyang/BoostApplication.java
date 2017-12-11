package com.anyang;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


import java.util.List;


@SpringBootApplication               // spring boot 注解
@EnableAutoConfiguration
public class BoostApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        // 启动该项目
        SpringApplication.run(BoostApplication.class,args);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);

        // 定义一个转换消息的对象
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        // 添加 fastJson 的配置信息
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);

        // 将配置添加到 消息转换对象中
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);

        // 将消息转换器添加到 converters 中
        converters.add(fastJsonHttpMessageConverter);
    }



}
