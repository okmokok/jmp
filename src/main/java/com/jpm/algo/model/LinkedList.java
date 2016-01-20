package com.jpm.algo.model;

public class LinkedList {
	private Node<Object> head;
	private Node<Object> tail;
	private int size = 0;
	
	public LinkedList() {
		
	}
	
	
	private class Node<T> {
		T data;
		Node<T> next;
		
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
		Node<Object> node = new Node<Object>(data);
		node.next = this.head;
		this.head = node;
		this.size++;
		
		if(node.next == null) {
			this.tail = head;
		}
	}
	
	public void addLast(Object data) {
		Node<Object> node = new Node<Object>(data);
		
		if (size == 0) {
			addFirst(data);
		} else {
			tail.next = node;
			node = tail;
			
			size++;
			
		}
	}
	
	public Node<Object> getNode(int index) {
		Node<Object> node = head;
		
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
			
			Node<Object> node = new Node<Object>(object);
			
			temp1.next = node;
			
			node.next = temp2;
			
			size++;
			
			if (node.next == null) {
				tail = node;
			}
			
		}		
	}
	
	public void removeFirst() {
		Node<Object> temp = head;
		head = temp.next;
		size--;
	}
	
	public void remove(int index) {
		if (index == 0) {
			removeFirst();
		} else {
			Node<Object> temp = this.getNode(index - 1);
			Node<Object> removeNode = temp.next;
			
			temp.next = temp.next.next;
			
			if (removeNode == tail) {
				tail = temp;
			}
			
			removeNode = null;
			
			size--;
			
			
		}
		
	}
	
	
	/**
	 * 특정한 값을 가진 엘리먼트의 인덱스 값을 검색.
	 * 값이 있다면 그 값이 발견되는 첫번째 인덱스 값을 리턴하고 값이 없다면 -1을 리턴.
	 * 
	 * @param data
	 * @return
	 */
	public int indexOf(Object data) {
		Node<Object> temp = head;
		int index = 0;
		
		while (temp.data != data) {
			temp = temp.next;
			index++;
			if (temp == null) {
				return -1;
			}
		}
		
		return index;
	}
	
	
	
}
