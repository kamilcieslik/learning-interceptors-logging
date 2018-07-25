package com.kamilcieslik.spring_boot.learninginterceptorslogging.config;

import com.kamilcieslik.spring_boot.learninginterceptorslogging.utils.correlation.CorrelationHeaderFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.Collections;

@Configuration
public class LoggingConfig {

    @Bean
    public FilterRegistrationBean<Filter> correlationHeaderFilter() {
        FilterRegistrationBean<Filter> filterRegBean = new FilterRegistrationBean<>();
        filterRegBean.setFilter(new CorrelationHeaderFilter());

        filterRegBean.setUrlPatterns(Collections.singletonList("/app/*"));

        return filterRegBean;
    }
}
