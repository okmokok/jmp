package com.jpm.algo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jpm.algo.bo.RecursionService;

@Controller
@RequestMapping(value = "/algo")
public class RecursionController {
	
	@Autowired 
	private RecursionService recursionService;
	
	@RequestMapping(value = {"/03"}, method = RequestMethod.GET)
	public String findAllBinaryString() {
		int bit = 2;
		
		Integer bArray[] = new Integer[bit];
		
		recursionService.printBinaryString(bit , bArray);
		
		return "home";
	}
}
