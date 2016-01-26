package com.jpm.algo.util;

/**
 * [참고]https://opentutorials.org/module/1335/8941
 *
 * @param <T>
 */
public class DoubleLinkedList<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size = 0;
	
	@SuppressWarnings("hiding")
	private class Node<T> {
		private Node<T> prev;
		private Node<T> next;
		private T data;
		
		public Node(T data) {
			this.data = data;
			this.prev = null;
			this.next = null;
		}
		
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	
	public void addFirst(T data) {
		Node<T> newNode = new Node<T>(data);
		
		newNode.next = head;
		
		if (head != null) {
			// 헤드가 가리키고 있는 노드의 이전 노드는 신규 생성한 노드이다.
			head.prev = newNode;
		}
		
		head = newNode;
		
		this.size++;
		
		if (head.next == null) {
			tail = head;
		}
	}
	
	public void addLast(T data) {
		Node<T> newNode = new Node<T>(data);
		
		if (this.size == 0) {
			addFirst(data);
		} else {
			
			tail.next = newNode;
			
			// 새로 추가된 노드의 이전은 tail이 가리키고 있는 노드이다.
			newNode.prev = tail;
			
			tail = newNode;
			
			this.size++;
		}
	}
	
	// 특정 위치에 추가
	public void add(int index , T data) {
		if (index == 0) {
			addFirst(data);
		} else {
			Node<T> temp1 = node(index - 1);
			Node<T> temp2 = temp1.next;
			Node<T> newNode = new Node<T>(data);
			
			temp1.next = newNode;
			
			// 새 노드의 next 로 temp2 가리킨다
			newNode.next = temp2;
			
			if (temp2 != null) {
				temp2.prev = newNode;
			}
			
			newNode.prev = temp1;
			
			this.size++;
			
			if (newNode.next == null) {
				tail = newNode;
			}
		}
	}
	
	public T removeFirst() {
		Node<T> temp = head;
		head = head.next;
		T returnData = temp.data;
		temp = null;
		
		if (head != null) {
			head.prev = null;
		}
		
		size--;
		
		return returnData;
	}
	
	public T remove(int index) {
		if (index == 0) {
			return removeFirst();
		} 
		
		Node<T> temp = node(index - 1);
		Node<T> todoDelNode = temp.next;
		temp.next = temp.next.next;
		
		if (temp.next != null) {
			temp.next.prev = temp;
		}
		
		T returnData = todoDelNode.data;
		
		if (todoDelNode == tail) {
			tail = temp;
		}
		
		todoDelNode = null;
		
		this.size--;
		
		return returnData;
	}
	
	public T removeLast() {
		return remove(this.size - 1);
	}

	public Node<T> node(int index) {
		Node<T> x;
		
		if ((this.size / 2) > index) {
			x = head;
			for (int i=0; i<index; i++) {
				x = x.next;
			}
		} else {
			x = tail;
			for (int i = this.size - 1; i > index ; i--) {
				x = x.prev;
			}
		}
			
		return x;
	}
	
	public int indexOf(T data) {
		Node<T> temp = head;
		
		int index = 0;
		
		while (temp.data != data) {
			temp = temp.next;
			index++;
			
			//  못찾았을 경우
			if (temp == null) {
				return -1;
			}
		}
		
		return index;
	}
	
	
	
	public T getData(int index) {
		return node(index).data;
	}
	
	public int size() {
		return this.size;
	}
	
	public void init() {
		for (int i=0; i < this.size; i++) {
			System.out.println(" remove data is " + remove(i));
		}
	}
	
	public String toString(DoubleLinkedList<T> doubleLinkedList) {
		String result = " [ ";
		
		System.out.println("this.size : " + this.size);
		
		for (int i=0; i < this.size; i++) {
			result += (doubleLinkedList.node(i).data + ", " );
		}
		
		result += " ] ";
		
		return result;
	}
}
