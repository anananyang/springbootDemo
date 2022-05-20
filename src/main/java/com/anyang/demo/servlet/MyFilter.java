package com.anyang.demo.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("myFilter.init()");
    }

    @Override
    public void destroy() {
        System.out.println("myFilter.destroy()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("myFilter.doFilter(): " + ((HttpServletRequest) servletRequest).getServletPath());
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
