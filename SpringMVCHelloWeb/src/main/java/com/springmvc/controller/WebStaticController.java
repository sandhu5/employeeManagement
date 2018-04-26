package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebStaticController {

	@RequestMapping(value = "/welcomeStatic", method = RequestMethod.GET)
	public String welcome() {
		return "welcomeStatic";
	}

	@RequestMapping(value = "/staticPage", method = RequestMethod.GET)
	public String redirect() {
		return "redirect:/staticContents/static.html";
	}
}