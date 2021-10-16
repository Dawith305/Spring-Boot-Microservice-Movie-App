package com.dawit.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class MovieCatalogServiceApplication {

	//Load Balanced: for the Rest template to provide the url to Eureka
	//And Eureka will resolve and send it the right service meaning when there
	//are available service for that url it will load balance and will send it to preferred one
	//injectable global Rest template instance instead of initializing everywhere
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(){

//		HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		//setting a timeout of 3seconds to avoid request overload and
		// slow and interdependent micro-services won't be responsive
//		httpComponentsClientHttpRequestFactory.setConnectTimeout(3000);

		return new RestTemplate();
	}

	@Bean
	public WebClient.Builder getWebClientBuilder(){
		return WebClient.builder();
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}

}
