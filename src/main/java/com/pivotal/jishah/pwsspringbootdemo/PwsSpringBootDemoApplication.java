package com.pivotal.jishah.pwsspringbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.pivotal.jishah.pwsspringbootdemo"})
public class PwsSpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PwsSpringBootDemoApplication.class, args);
	}

}
