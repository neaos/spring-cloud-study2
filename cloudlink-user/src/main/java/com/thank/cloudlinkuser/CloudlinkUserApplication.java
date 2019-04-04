package com.thank.cloudlinkuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CloudlinkUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudlinkUserApplication.class, args);
	}
}
