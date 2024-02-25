package com.manutencaolabs.manutencaolabs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "com.manutencaolabs.models")
@SpringBootApplication
public class ManutencaolabsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManutencaolabsApplication.class, args);
	}

}
