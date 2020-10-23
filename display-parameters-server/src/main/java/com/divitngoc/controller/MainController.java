package com.divitngoc.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@GetMapping("/")
	public String main(@RequestParam final MultiValueMap<String, String> duplicateRequestParams, final ModelMap model) {
		System.out.println("Test: " + duplicateRequestParams);
		final Map<String, String> uniqueRequestParams = new HashMap<>();

		Iterator<String> it = duplicateRequestParams.keySet().iterator();
		while(it.hasNext()) {
			String theKey = (String) it.next();
			if (duplicateRequestParams.get(theKey).size() > 1) {
				for (int index = 0; index < duplicateRequestParams.get(theKey).size(); index++) {
					String duplicatedValue = duplicateRequestParams.get(theKey).get(index);
					uniqueRequestParams.put(theKey + " ["+(index+1)+"]", duplicatedValue);
				}
			} else {
				uniqueRequestParams.put(theKey, duplicateRequestParams.getFirst(theKey));
			}
		}

		model.addAttribute("parameters", uniqueRequestParams);
		return "display-parameters"; // view
	}
}
