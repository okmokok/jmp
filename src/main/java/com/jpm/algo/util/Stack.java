package com.jpm.algo.util;
/**
 * 
 *
 * @param <T>
 */
public class Stack<T> {
	
	private DoubleLinkedList<T> linkedList;
	
	private final char[] openChar = {'(', '{' , '[' };
	private final char[] closeChar = {')' , '}' , ']' };
	
	public Stack() {
		linkedList = new DoubleLinkedList<T>();
	}
	
	public void push(T data) {
		linkedList.addLast(data);
	}
	
	public T pop() throws Exception {
		
		if (isEmptyStack()) {
			throw new Exception();
		}
		
		return linkedList.removeLast();
	}
	
	public T top() throws Exception {
		
		if (isEmptyStack()) {
			throw new Exception();
		}
		
		return linkedList.getData(size() - 1);
	}
	
	public int size() {
		return linkedList.size();
	}
	
	public boolean isEmptyStack() {
		return this.size() == 0;
	}
	
	@SuppressWarnings("unchecked")
	public boolean isBalancing(String input) throws Exception {
		boolean result = false;
		
		char[] symbols = input.toCharArray();
		
		for (int i=0; i<symbols.length; i++) {
			
			Character symbol = symbols[i];
			
			if (isOpenChracter(symbol)) {
				this.push((T) symbol);
			}
			
			if (isCloseChracter(symbol)) {
				if (isPair(symbol)) {
					this.pop();
				}
			}
		}
		
		System.out.println("남아 있는 데이터 수 : " + this.size()  + " , stack : " + this.toString());
		
		if (this.size() == 0) {
			result = true;
		}
		
		return result;
	}
	
	private boolean isOpenChracter(Character symbol) {
		boolean result = false;
		
		for (Character open : openChar) {
			if (symbol == open) {
				result = true;
			}
		}
		return result;
	}
	
	private boolean isCloseChracter(Character symbol) {
		boolean result = false;
		
		for (Character close : closeChar) {
			if (symbol == close) {
				result = true;
			}
		}
		
		return result;
	}	
	
	private boolean isPair(Character symbol) throws Exception {
		boolean result = false;

		int index = 0;
		
		for (int i=0; i < closeChar.length; i++) {
			if (symbol == closeChar[i]) {
				index = i;
				break;
			}
		}
		
		if (openChar[index] == (Character)this.top() ) {
			result = true;
		}
		
		return result;
	}	
	
	public String toString() {
		String result = "";
		
		for (int i=0; i < linkedList.size(); i++) {
			result += linkedList.getData(i) + "\n";
		}
		
		return result;
	}
}
