package com.homains;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.homains.repository.UserRepository;

@EntityScan ("com.homains.model")
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@SpringBootApplication
public class HomainsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomainsApplication.class, args);
	}

}
