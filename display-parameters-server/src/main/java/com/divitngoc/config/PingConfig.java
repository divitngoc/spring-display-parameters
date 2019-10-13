package com.divitngoc.config;

import java.time.Clock;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.divitngoc.service.PingService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class PingConfig {

	private final PingService pingService;

	@Value("${ping.url.health}")
	private String healthUrl;
	@Value("${ping.from}")
	private LocalTime from;
	@Value("${ping.to}")
	private LocalTime to;

	@Scheduled(fixedDelay = 1000 * 60 * 25) // 25min
	public void pingHealth() {
		final LocalTime now = LocalTime.now(Clock.systemUTC());
		if (now.isAfter(from) && now.isBefore(to)) {
			log.info("Pinging health {}...", healthUrl);
			pingService.pingEndpoint(healthUrl);
		}
	}
}
