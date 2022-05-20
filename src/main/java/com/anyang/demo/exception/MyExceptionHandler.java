package com.anyang.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler({RuntimeException.class, })
    public ModelAndView handleException(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        StringWriter stringWriter = null;
        PrintWriter printWriter = null;
        try {
            stringWriter = new StringWriter();
            printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);

        }finally {
            printWriter.flush();
            stringWriter.flush();
        }

        modelAndView.addObject("trace", stringWriter.toString());
        modelAndView.addObject("status", 500);
        modelAndView.addObject("message", e.getMessage());
        modelAndView.addObject("timestamp", new Date());
        modelAndView.setViewName("myErrorPage");
        return modelAndView;
    }
}
