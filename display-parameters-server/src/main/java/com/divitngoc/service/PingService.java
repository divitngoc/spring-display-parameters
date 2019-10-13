package com.divitngoc.service;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PingService {

	private final RestTemplate restTemplate;

	public void pingEndpoint(final String url) {
		restTemplate.getForEntity(url, String.class);
	}

}
