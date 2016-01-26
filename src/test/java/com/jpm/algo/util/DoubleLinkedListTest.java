package com.jpm.algo.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class DoubleLinkedListTest {
	
	private DoubleLinkedList<Object> doubleLinkedList;
	
	@Before
	public void setup() {
	}
	
	@Test
	public void testAddFirst() {
		doubleLinkedList = new DoubleLinkedList<>();
		doubleLinkedList.addFirst(30);
		doubleLinkedList.addFirst(20);
		doubleLinkedList.addFirst(10);
		
		Assert.assertEquals(30, doubleLinkedList.getData(2));
		Assert.assertEquals(20, doubleLinkedList.getData(1));
		Assert.assertEquals(10, doubleLinkedList.getData(0));
	}
	
	@Test
	public void testAddLast() {
		doubleLinkedList = new DoubleLinkedList<>();
		doubleLinkedList.addLast(300);
		doubleLinkedList.addLast(200);
		doubleLinkedList.addLast(100);

		int lastIndex = doubleLinkedList.size() - 1;
		
		Assert.assertEquals(100, doubleLinkedList.getData(lastIndex));

	}
	
	@Test
	public void testAdd() {
		doubleLinkedList = new DoubleLinkedList<>();
		doubleLinkedList.addLast("a");
		doubleLinkedList.addLast("p");
		doubleLinkedList.addLast("l");
		doubleLinkedList.addLast("e");

		doubleLinkedList.add(2, "p");
		
		int lastIndex = doubleLinkedList.size() - 1;
		
		Assert.assertEquals("e", doubleLinkedList.getData(lastIndex));
		
	}
	
	@Test
	public void testRemoveFirst() {
		doubleLinkedList = new DoubleLinkedList<>();
		doubleLinkedList.addLast("a");
		doubleLinkedList.addLast("p");
		doubleLinkedList.addLast("p");
		doubleLinkedList.addLast("l");
		doubleLinkedList.addLast("e");
		
		Assert.assertEquals("a", doubleLinkedList.removeFirst());
	}
	
	@Test
	public void testRemove() {
		doubleLinkedList = new DoubleLinkedList<>();
		doubleLinkedList.addLast("a");
		doubleLinkedList.addLast("p");
		doubleLinkedList.addLast("p");
		doubleLinkedList.addLast("l");
		doubleLinkedList.addLast("e");
		
		Assert.assertEquals("l", doubleLinkedList.remove(3));
	}
	
	@Test
	public void testRemoveLast() {
		doubleLinkedList = new DoubleLinkedList<>();
		doubleLinkedList.addLast("a");
		doubleLinkedList.addLast("p");
		doubleLinkedList.addLast("p");
		doubleLinkedList.addLast("l");
		doubleLinkedList.addLast("e");
		
		Assert.assertEquals("e", doubleLinkedList.removeLast());
	}
}
