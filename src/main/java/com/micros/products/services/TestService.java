package com.micros.products.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// @Component
@Slf4j
public class TestService implements CommandLineRunner {

    @Value("${server.port}")
    private String serverPort;

    @Override
    public void run(String... args) throws Exception {
        log.info("Server port: {}", serverPort);
    }
}
