package com.divitngoc.controller;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
public class MainController {

	private final String redirectUrl = "https://display-parameters.com";

	@GetMapping("/")
	public RedirectView main(@RequestParam final MultiValueMap<String, String> multiValueMap,
			final HttpServletRequest request) {
		URI uri = UriComponentsBuilder.fromHttpUrl(redirectUrl).queryParams(multiValueMap).build().toUri();
		return new RedirectView(uri.toString());
	}

}
