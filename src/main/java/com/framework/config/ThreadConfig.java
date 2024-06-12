package com.framework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/**
 *@author: Joshma
 *@date: 2024-06-12
 *@desc:
 */
@Configuration
public class ThreadConfig {

    @Bean
    public Executor taskExecutor() {
        return Executors.newFixedThreadPool(10);
    }
}
