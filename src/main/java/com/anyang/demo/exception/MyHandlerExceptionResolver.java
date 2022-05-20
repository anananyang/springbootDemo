package com.anyang.demo.exception;

import com.sun.xml.internal.ws.handler.HandlerException;
import org.springframework.core.annotation.Order;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

@Order(Integer.MIN_VALUE)
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {


    @Nullable
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, @Nullable Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        StringWriter stringWriter = null;
        PrintWriter printWriter = null;
        try {
            stringWriter = new StringWriter();
            printWriter = new PrintWriter(stringWriter);
            ex.printStackTrace(printWriter);

        }finally {
            printWriter.flush();
            stringWriter.flush();
        }

        modelAndView.addObject("trace", stringWriter.toString());
        modelAndView.addObject("status", 500);
        modelAndView.addObject("message", ex.getMessage());
        modelAndView.addObject("timestamp", new Date());
        modelAndView.setViewName("myErrorPage");
        return modelAndView;
    }
}
