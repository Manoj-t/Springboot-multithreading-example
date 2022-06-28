package com.manoj.executor.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync // This annotation enables Spring's asynchronous execution capability
public class AsyncConfig {

    @Bean(name="taskExecutor")
    public Executor taskExecutorSetUp(){

        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(2);
        threadPoolTaskExecutor.setMaxPoolSize(3);
        threadPoolTaskExecutor.setQueueCapacity(50);
        threadPoolTaskExecutor.setThreadGroupName("first-group");
        threadPoolTaskExecutor.setThreadNamePrefix("first-group-Thread-");

        threadPoolTaskExecutor.initialize();

        return threadPoolTaskExecutor;
    }
}
