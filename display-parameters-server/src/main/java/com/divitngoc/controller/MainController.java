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
    public String main(@RequestParam final MultiValueMap<String, String> multiValueMap, final ModelMap model) {
        final Map<String, String> uniqueRequestParams = convertToUniqueRequestParams(multiValueMap);

        model.addAttribute("parameters", uniqueRequestParams);
        return "display-parameters"; // view
    }

    private Map<String, String> convertToUniqueRequestParams(MultiValueMap<String, String> multiValueMap) {
        final Map<String, String> uniqueRequestParams = new HashMap<>();

        Iterator<String> it = multiValueMap.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            if (multiValueMap.get(key).size() > 1) {
                for (int i = 0; i < multiValueMap.get(key).size(); i++) {
                    String value = multiValueMap.get(key).get(i);
                    uniqueRequestParams.put(key + " [" + (i + 1) + "]", value);
                }
            } else {
                uniqueRequestParams.put(key, multiValueMap.getFirst(key));
            }
        }

        return uniqueRequestParams;
    }
}
