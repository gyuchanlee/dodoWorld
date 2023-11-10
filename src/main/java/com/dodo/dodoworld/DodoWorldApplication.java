package com.dodo.dodoworld;

import com.dodo.dodoworld.domain.Member;
import jakarta.annotation.PostConstruct;
import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;
import java.util.UUID;

@EnableJpaAuditing
@SpringBootApplication
public class DodoWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(DodoWorldApplication.class, args);
    }

    @Bean
    public AuditorAware<String> auditorProvider() {
        // 나중에 의미있는 세션정보등을 넣기.
        return () -> Optional.of(UUID.randomUUID().toString());
    }

}
