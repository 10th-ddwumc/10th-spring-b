package com.ddwuumc.week4;

import org.springframework.boot.SpringApplication;

public class TestWeek4Application {

    public static void main(String[] args) {
        SpringApplication.from(Week4Application::main).with(TestcontainersConfiguration.class).run(args);
    }

}
