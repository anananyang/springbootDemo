package com.anyang.demo.validator;

import com.anyang.demo.domain.user.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MyValidator1 implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(User.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        System.out.println("MyValidator1.validate()");
    }
}
