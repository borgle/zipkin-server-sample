package com.gkeeps.gateway;

import com.gkeeps.gateway.configuration.BasicAuthorizationZipkinRestTemplateCustomizer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.sleuth.zipkin2.ZipkinProperties;
import org.springframework.cloud.sleuth.zipkin2.ZipkinRestTemplateCustomizer;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@EnableZuulProxy
@EnableCircuitBreaker
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    ZipkinRestTemplateCustomizer zipkinRestTemplateCustomizer(ZipkinProperties zipkinProperties) {
        return new BasicAuthorizationZipkinRestTemplateCustomizer(zipkinProperties);
    }
}
