package com.pfe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;




@EnableDiscoveryClient
@SpringBootApplication
public class T24ValidatorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(T24ValidatorServiceApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
