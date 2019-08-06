package com.ihrm.report;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.ApplicationContext;

import java.util.stream.Stream;


@SpringBootApplication
public class JasperApplication {
    public static void main(String[] args) {
        SpringApplication.run(JasperApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context) {
        return args -> {
            System.out.println("打印所有bean:");
            Stream.of(context.getBeanDefinitionNames()).sorted().forEach(System.out::println);
        };
    }
}