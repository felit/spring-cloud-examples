package com.felit.springCloud.registry;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Server {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Server.class).web(true).run(args);
    }
}
