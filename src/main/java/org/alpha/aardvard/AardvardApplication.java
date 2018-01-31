package org.alpha.aardvard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class AardvardApplication {

	private static final Logger log = LoggerFactory.getLogger(AardvardApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(AardvardApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Quote quote = restTemplate.getForObject(
					"https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
			log.info(quote.toString());
		};
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer(){
		return new WebMvcConfigurerAdapter() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				// TODO Auto-generated method stub
				registry.addMapping("/greeting-javaconfig").allowedOrigins("http://localhost:9000");
			}
			
		};
	}
}

/**
 * The RestTemplateBuilder is injected by Spring, and if you use it to create a
 * RestTemplate then you will benefit from all the autoconfiguration that happens
 * in Spring Boot with message converters and request factories. We also extract 
 * the RestTemplate into a @Bean to make it easier to test(it can be mocked more
 * easily that way).
 */
