package com.jpm.algo.util;

public class LinkedList<T> {
	private Node<T> head;
	private Node<T> tail;
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

	public void addFirst(T data) {
		Node<T> node = new Node<T>(data);
		node.next = this.head;
		this.head = node;
		this.size++;
		
		if(node.next == null) {
			this.tail = head;
		}
	}
	
	public void addLast(T data) {
		Node<T> node = new Node<T>(data);
		
		if (size == 0) {
			addFirst(data);
		} else {
			tail.next = node;
			node = tail;
			
			size++;
			
		}
	}
	
	public Node<T> getNode(int index) {
		Node<T> node = head;
		
		for (int i=0; i<index; i++) {
			node = node.next;
		}
		
		return node;
	}
	
	public T getData(int index) {
		return this.getNode(index).getData();
	}
	
	public void add(int index , T object) {
		if (index == 0) {
			addFirst(object);
		} else {
			Node<T> temp1 = this.getNode(index - 1);
			
			Node<T> temp2 = temp1.next;
			
			Node<T> node = new Node<T>(object);
			
			temp1.next = node;
			
			node.next = temp2;
			
			size++;
			
			if (node.next == null) {
				tail = node;
			}
			
		}		
	}
	
	public void removeFirst() {
		Node<T> temp = head;
		head = temp.next;
		size--;
	}
	
	public void remove(int index) {
		if (index == 0) {
			removeFirst();
		} else {
			Node<T> temp = this.getNode(index - 1);
			Node<T> removeNode = temp.next;
			
			temp.next = temp.next.next;
			
			if (removeNode == tail) {
				tail = temp;
			}
			
			removeNode = null;
			
			size--;
			
			
		}
		
	}
	
	
	/**
	 * �듅�젙�븳 媛�?�쓣 媛�吏� �뿕?��?�㉫�듃�쓽 �씤�뜳�뒪 媛�?�쓣 寃��깋.
	 * 媛�?�씠 �엳�떎硫� 洹� 媛�?�씠 諛쒓껄�릺�?�� 泥ル쾲吏�? �씤�뜳�뒪 媛�?�쓣 ?��?�꽩�븯?�� 媛�?�씠 �뾾�떎硫� -1�쓣 ?��?�꽩.
	 * 
	 * @param data
	 * @return
	 */
	public int indexOf(T data) {
		Node<T> temp = head;
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
