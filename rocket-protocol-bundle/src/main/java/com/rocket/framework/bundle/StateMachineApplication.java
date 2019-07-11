package com.rocket.framework.bundle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Created by zksun on 2019/7/11.
 */

@SpringBootApplication
@ServletComponentScan
public class StateMachineApplication {
    public static void main(String[] args) {
        SpringApplication.run(StateMachineApplication.class, args);
    }
}
