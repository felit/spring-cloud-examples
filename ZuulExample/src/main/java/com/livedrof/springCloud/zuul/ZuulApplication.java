package com.livedrof.springCloud.zuul;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
//@SpringCloudApplication
public class ZuulApplication {
    public static void main(String args[]) {
//        SpringApplication.run(ZuulApplication.class);
        ServletRegistrationBean a;
        new SpringApplicationBuilder(ZuulApplication.class).web(true).run(args);
    }
}
