package com.sortnumbers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {
	/**
	 * @returns the "sortnumber" which is the file name of jsp.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homepage() {
		return "sortnumber";
	}
}