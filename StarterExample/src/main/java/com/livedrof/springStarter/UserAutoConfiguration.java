package com.livedrof.springStarter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserAutoConfiguration {
    @Bean
    public UserService dbCountRunner() {
        return new UserService();
    }
}
