package com.tongpao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 启动类
 *
 * @author raojing
 * @data 2020/5/30 22:51
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SecurityAuthApplication {

    public static void main(String[] args){
        SpringApplication.run(SecurityAuthApplication.class, args);
    }

}
