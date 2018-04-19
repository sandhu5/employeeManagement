package com.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/hello")

public class HelloWorldController {

	@RequestMapping(value = "/model", method = RequestMethod.GET)
	public String sayHelloWorldUSingModel(Model model) {
		Map<String, String> map = new HashMap<String,String>();
		map.put("author", "B.S.Sandhu");
		model.addAttribute("message", "Spring 4.3.7 MVC Framework Hello World Example using model ");
		model.mergeAttributes(map);
		return "hello";
	}

	@RequestMapping(value = "/modelMap", method = RequestMethod.GET)
	public String sayHelloWorldUSingModelMap(ModelMap model) {
		model.addAttribute("message", "Spring 4.3.7 MVC Framework Hello World Example using modelMap!");
		model.addAttribute("author", "B.S.Sandhu");
		return "hello";
	}

	@RequestMapping(value = "/modelAndView")
	public ModelAndView sayHelloWorldUSingModelAndView() {
		ModelAndView modelAndView = new ModelAndView("hello");
		modelAndView.addObject("message", "Spring 4.3.7 MVC Framework Hello World Example using model and view ");
		modelAndView.addObject("author", "B.S.Sandhu");
		return modelAndView;
	}
}
