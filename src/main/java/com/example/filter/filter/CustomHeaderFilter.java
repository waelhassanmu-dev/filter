package com.example.filter.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Slf4j
@RequiredArgsConstructor
public class CustomHeaderFilter extends OncePerRequestFilter /*implements Ordered*/ {

    //private final ApplicationContext applicationContext;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("custom header filter to inject a header");
        filterChain.doFilter(request, response);
    }

    /*
    @Override
    public int getOrder() {
        if (applicationContext.containsBean("headerLoggerSpringInternalFilter"))
            return -1;
        return LOWEST_PRECEDENCE;
    }

     */
}
