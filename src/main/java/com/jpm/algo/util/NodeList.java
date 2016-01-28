package com.jpm.algo.util;


public class NodeList<T> {
	
	private class Node {
		T value;
		Node next;
	}
	
	private Node header;
	
	private int size;
	
	public NodeList() {
		header = new Node();
		size = 0;
	}
	
	public boolean add(int pos , T value) {
		if (pos < 0 || pos > this.size) {
			return false;
		}
		
		Node dest = this.header;
		
		for (int i=0; i < pos; i++) {
			dest = dest.next;
		}
		
		Node inserted = new Node();
		inserted.value = value;
		inserted.next = dest.next;
		dest.next = inserted;
		this.size++;
		
		return true;
	}
	
	public boolean addLast(T value) {
		return add(this.size , value);
	}
	
	public T remove(int pos) {
		if (pos < 0 || pos >= this.size) {
			return null;
		}
		
		Node dest = this.header.next;
		Node preDest = null;
		
		for (int i=0; i<pos; i++) {
			preDest = dest;
			dest = dest.next;
		}
		
		preDest.next = dest.next;
		
		T returnValue = dest.value;
		dest = null;
		this.size--;
		
		return returnValue;
	}
	
	public T get(int pos) {
		if (pos < 0 || pos >= this.size) {
			return null;
		}
		
		Node dest = header.next;
		
		for (int i=0; i < pos; i++) {
			dest = dest.next;
		}
		
		return dest.value;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(" [ ");
		
		for (int i=0; i < this.size; i++) {
			sb.append(get(i));
			
			if (i < this.size -1) {
				sb.append(" , ");
			}
		}
		
		sb.append(" ] ");
		
		return sb.toString();
	}
}
