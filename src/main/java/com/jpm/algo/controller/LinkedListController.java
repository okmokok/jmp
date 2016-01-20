package com.jpm.algo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jpm.algo.model.LinkedList;
 
// https://opentutorials.org/module/1335/8857
@Controller
public class LinkedListController {
	@RequestMapping(value = {"/04"}, method = RequestMethod.GET)
	public String findAllBinaryString() {
		LinkedList linkedList = new LinkedList();
		
		linkedList.addFirst(30);
		linkedList.addFirst(20);
		linkedList.addFirst(10);
		
		linkedList.add(1, 15);
		
		for (int i=0; i<linkedList.getSize(); i++) {
			System.out.println(linkedList.getNode(i)); 
		}
	
		
		return "home";
	}
	
	@RequestMapping(value = {"/04-1"}, method = RequestMethod.GET)
	public String findIndexOf() {
		LinkedList linkedList = new LinkedList();
		
		linkedList.addFirst(30);
		linkedList.addFirst(20);
		linkedList.addFirst(10);
		
		System.out.println(linkedList.indexOf(10)); // 0
		System.out.println(linkedList.indexOf(20)); // 1
		System.out.println(linkedList.indexOf(30)); // 2..

	
		
		return "home";
	}
}
