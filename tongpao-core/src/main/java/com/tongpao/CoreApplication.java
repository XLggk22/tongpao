package com.tongpao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>Title: Application</p>
 * <p>Description: </p>
 *
 * @author Administrator
 * @version 1.0
 * @date 2020/5/28 11:16
 */
@MapperScan("com.tongpao.dao")
@SpringBootApplication
@EnableDiscoveryClient
public class CoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class,args);
	}
}
