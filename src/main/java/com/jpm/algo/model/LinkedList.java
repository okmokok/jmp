package com.jpm.algo.model;

public class LinkedList {
	private Node head;
	private Node tail;
	private int size = 0;
	
	public LinkedList() {
		
	}
	
	
	private class Node<T> {
		T data;
		Node next;
		
		public Node(T data) {
			this.data = data;
			this.next = null;
		}
		
		public T getData() {
			return this.data;
		}
		

		
		public String toString() {
			return String.valueOf(data);
		}
	}
	
	public int getSize() {
		return this.size;
	}	

	public void addFirst(Object data) {
		Node node = new Node(data);
		node.next = this.head;
		this.head = node;
		this.size++;
		
		if(node.next == null) {
			this.tail = head;
		}
	}
	
	public void addLast(Object data) {
		Node node = new Node(data);
		
		if (size == 0) {
			addFirst(data);
		} else {
			tail.next = node;
			node = tail;
			
			size++;
			
		}
	}
	
	public Node getNode(int index) {
		Node node = head;
		
		for (int i=0; i<index; i++) {
			node = node.next;
		}
		
		return node;
	}
	
	public Object getData(int index) {
		return this.getNode(index).getData();
	}
	
	public void add(int index , Object object) {
		if (index == 0) {
			addFirst(object);
		} else {
			Node<Object> temp1 = this.getNode(index - 1);
			
			Node<Object> temp2 = temp1.next;
			
			Node<Object> node = new Node(object);
			
			temp1.next = node;
			
			node.next = temp2;
			
			size++;
			
			if (node.next == null) {
				tail = node;
			}
			
		}		
	}
	
	public void removeFirst() {
		Node temp = head;
		head = temp.next;
		size--;
	}
	
	public void remove(int index) {
		if (index == 0) {
			removeFirst();
		} else {
			Node temp = this.getNode(index - 1);
			Node removeNode = temp.next;
			
			temp.next = temp.next.next;
			
			if (removeNode == tail) {
				tail = temp;
			}
			
			removeNode = null;
			
			size--;
			
			
		}
		
	}
	
	public void indexOf() {
		// test
	}
	
	
}
