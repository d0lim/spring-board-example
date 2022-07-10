package com.studyspring.boardexample.config;

import com.studyspring.boardexample.constants.EnumMapper;
import com.studyspring.boardexample.domain.UserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Order(1)
@Configuration
public class WebConfig {
    @Bean
    public EnumMapper enumMapper() {
        EnumMapper enumMapper = new EnumMapper();
        enumMapper.put("UserRole", UserRole.class);

        return enumMapper;
    }
}
