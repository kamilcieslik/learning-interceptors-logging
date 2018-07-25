package com.kamilcieslik.spring_boot.learninginterceptorslogging.utils.correlation;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@Slf4j
public class CorrelationHeaderFilter implements Filter {

    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        final HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String currentCorrId = httpServletRequest.getHeader("correlationId");

        if (currentCorrId == null) {
            currentCorrId = UUID.randomUUID().toString();
            log.info("Correlation id not found in Request. New correlation id generated : " + currentCorrId);
        } else {
            log.info("Found correlation id in Request: " + currentCorrId);
        }

        MDC.put("correlationId", currentCorrId);

        filterChain.doFilter(httpServletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
