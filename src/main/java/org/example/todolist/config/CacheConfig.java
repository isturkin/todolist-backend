package org.example.todolist.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.example.todolist.domain.model.TaskEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {

    @Bean
    public Cache<Long, TaskEntity> tasksCache() {
        return Caffeine.newBuilder()
                .build();
    }
}
