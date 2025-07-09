package com.tmane.springbootmvcdemo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringBootMvcDemoApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(SpringBootMvcDemoApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }

}
