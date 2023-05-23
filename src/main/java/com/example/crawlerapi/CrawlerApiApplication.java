package com.example.crawlerapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Shop",
				version = "1.0.0",
				description = "Example Crawler with API"))
public class CrawlerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrawlerApiApplication.class, args);
	}

}
