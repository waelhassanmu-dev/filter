package com.example.filter.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;
import static org.springframework.core.Ordered.LOWEST_PRECEDENCE;

@Component
@Slf4j
//@Order(HIGHEST_PRECEDENCE)
@Order(0)
public class HeaderLoggerSpringInternalFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Collections.list(request.getHeaderNames()).forEach(header -> log.info("header: {}={}", header, request.getHeader(header)));

        filterChain.doFilter(request, response);
    }
}
