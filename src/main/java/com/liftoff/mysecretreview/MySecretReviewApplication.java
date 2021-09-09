package com.liftoff.mysecretreview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan
public class MySecretReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySecretReviewApplication.class, args);
	}

}
