package com.spring.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.springframework.context.annotation.Bean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class SearchApplication{


    public static void main(String[] args) {
        SpringApplication.run(SearchApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
