package com.divitngoc.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class RestTemplateConfig {

	private final RestTemplateBuilder restBuilder;

	@Bean
	public RestTemplate restTemplate() {
		return restBuilder.build();
	}

}
