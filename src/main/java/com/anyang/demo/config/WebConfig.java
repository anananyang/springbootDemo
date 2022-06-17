package com.anyang.demo.config;

import com.anyang.demo.exception.MyHandlerExceptionResolver;
import com.anyang.demo.interceptor.MyInterceptor;
import com.anyang.demo.validator.MyValidator1;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer getMyWebMvcConfigurer() {
        return new WebMvcConfigurer() {

            // 添加自定义拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new MyInterceptor())
                        .addPathPatterns("/**")
                        .excludePathPatterns("/login");
            }

            // 自定义异常处理
//            @Override
//            public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
//                resolvers.add(0, new MyHandlerExceptionResolver());
//            }


            @Nullable
            @Override
            public Validator getValidator() {
                return new MyValidator1();
            }
        };

    }
}



