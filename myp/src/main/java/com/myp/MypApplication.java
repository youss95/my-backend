package com.myp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MypApplication {

    public static void main(String[] args) {
        SpringApplication.run(MypApplication.class, args);
    }

}
