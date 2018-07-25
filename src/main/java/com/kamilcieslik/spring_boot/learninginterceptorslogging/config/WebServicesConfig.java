package com.kamilcieslik.spring_boot.learninginterceptorslogging.config;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;

@Configuration
@EnableWs
public class WebServicesConfig {

    @Bean
    public ServletRegistrationBean<CXFServlet> ServletRegistrationBeanWsDispatcherServlet() {
        CXFServlet cxfServlet = new CXFServlet();
        return new ServletRegistrationBean<>(cxfServlet, "/services/*");
    }

    @Bean(name= Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }
}


