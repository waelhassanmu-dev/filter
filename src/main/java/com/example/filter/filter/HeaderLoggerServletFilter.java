package com.example.filter.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collections;

//@Component
@Slf4j
public class HeaderLoggerServletFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Collections.list(request.getHeaderNames()).forEach(header -> log.info("header: {}={}", header, request.getHeader(header)));

        filterChain.doFilter(request, servletResponse);
    }
}
