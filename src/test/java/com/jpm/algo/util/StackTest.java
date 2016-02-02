package com.jpm.algo.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jpm.config.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebAppConfiguration.class)
public class StackTest {
	
	private Stack<Object> stack;

	@Before
	public void setup() {
	}
	
	@Test
	public void testPush() {
		stack = new Stack<Object>();
		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		
		Assert.assertEquals(5, stack.size());
	}
	
	@Test
	public void testPop() throws Exception {
		stack = new Stack<Object>();
		stack.push(5);
		stack.push(4);
 		stack.push(3);
		stack.push(2);
		stack.push(1);
		
		Assert.assertEquals(1 , stack.pop());
		Assert.assertEquals(2 , stack.pop());
	}
	
	@Test
	public void testTop() throws Exception {
		stack = new Stack<Object>();
		stack.push(5);
		stack.push(4);
 		stack.push(3);
		stack.push(2);
		stack.push(1);
		
		Assert.assertEquals(1 , stack.top());
		
		stack.pop();
		
		Assert.assertEquals(2 , stack.top());
	}
	
	@Test
	public void testIsBalancing() throws Exception {
		String input = "()(()[()]";
		Assert.assertEquals(false , new Stack<Object>().isBalancing(input));

		String input2 = "()()[()]";
		Assert.assertEquals(true , new Stack<Object>().isBalancing(input2));
	}
}
