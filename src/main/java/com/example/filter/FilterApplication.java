package com.example.filter;

import com.example.filter.filter.CustomHeaderFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;

@SpringBootApplication
@RequiredArgsConstructor
public class FilterApplication {

    private final ApplicationContext applicationContext;
    public static void main(String[] args) {
        SpringApplication.run(FilterApplication.class, args);
    }

    @Bean
    FilterRegistrationBean<CustomHeaderFilter> customHeaderFilterFilterRegistrationBean(CustomHeaderFilter customHeaderFilter) {
        final FilterRegistrationBean<CustomHeaderFilter> filterRegistrationBean = new FilterRegistrationBean<>(customHeaderFilter);
        if (applicationContext.containsBean("headerLoggerSpringInternalFilter"))
            filterRegistrationBean.setOrder(-1);
        else
            filterRegistrationBean.setOrder(Ordered.LOWEST_PRECEDENCE);

        return filterRegistrationBean;
    }
}
