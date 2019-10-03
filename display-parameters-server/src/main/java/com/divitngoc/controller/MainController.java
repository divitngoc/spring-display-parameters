package com.divitngoc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@GetMapping("/")
	public String main(@RequestParam final Map<String, String> requestParams, final ModelMap model) {
		model.addAttribute("parameters", requestParams);
		return "display-parameters"; // view
	}

}
