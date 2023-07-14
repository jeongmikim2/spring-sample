package com.gmarket.example;

import com.ebaykorea.saturn.moa.EnableMoA;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMoA
public class SpringSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSampleApplication.class, args);
	}

}
