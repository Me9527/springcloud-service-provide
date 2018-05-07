package com.example.provide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.*.**")     //组件扫描
@EnableDiscoveryClient          //激活DiscoveryClient实现
@SpringBootApplication
public class SpringcloudServiceProvideApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudServiceProvideApplication.class, args);
	}
}
