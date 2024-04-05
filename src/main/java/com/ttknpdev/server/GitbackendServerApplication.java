package com.ttknpdev.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer // Mark this app is a spring cloud server
public class GitbackendServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GitbackendServerApplication.class, args);
    }

}
