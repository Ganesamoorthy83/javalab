package com.sortnumbers.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sortnumbers.model.SortResult;
import com.sortnumbers.model.UserInput;
import com.sortnumbers.service.SortService;

@RestController
public class SortController {

	private SortService service = new SortService();
	private Logger logger = Logger.getLogger(this.getClass().getName());

	/**
	 * This functionality delegates the given input to SortService.
	 * 
	 * @param userInput
	 * @returns the SortResult
	 */
	@RequestMapping(value = "/sortnumbers", method = RequestMethod.POST)
	public SortResult sortNumbers(@RequestBody UserInput userInput) {
		SortResult res = null;
		if (!userInput.getUnsortednumbers().isEmpty())
			res = service.sort(userInput.getUnsortednumbers());

		logger.info(res);
		return res;
	}
}
