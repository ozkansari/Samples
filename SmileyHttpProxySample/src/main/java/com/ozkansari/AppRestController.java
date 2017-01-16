package com.ozkansari;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppRestController {

	@RequestMapping("/")
	public String index() {
		return "Greetings!";
	}

	@RequestMapping("/{path}")
	public String solrExample(@PathVariable String path) {
		return "Greetings from " + path;
	}

}
