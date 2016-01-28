package algo;

public class LinkedList {
	Node first;
	Node last;

	public LinkedList() {
		first = new Node();
		last = new Node();
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addFirst(10);
		list.addFirst(20);
		list.addFirst(30);
		list.addLast(40);
		list.addLast(50);
		list.addLast(60);
		
		list.addNode(10, 24);

		list.printList();
		list.getNode(0);
	}

	private void addFirst(Object data) {
		Node newNode = new Node(data);

		if (first.nextNode == null) {
			first.nextNode = newNode;
			last.nextNode = newNode;
			return;
		}

		Node temp = new Node();
		temp = first.nextNode;
		first.nextNode = newNode;
		newNode.nextNode = temp;
	}

	private void addLast(Object data) {
		if (last.nextNode == null) {
			addFirst(data);
			return;
		}

		Node newNode = new Node(data);
		last.nextNode.nextNode = newNode;
		last.nextNode = newNode;
	}

	private void addNode(int index, Object data) {
		if (index == 0) {
			addFirst(data);
			return;
		}
		
		Node prevNode = first.nextNode;
		for (int i = 0; i < index - 1; i++) {			
			prevNode = prevNode.nextNode;
			
			if (prevNode == null) {
				System.out.println("[ERROR] last node index : " + i);
				return;
			}
		}
		
		if (prevNode.nextNode == null) {
			addLast(data);
			return;
		}
		
		Node newNode = new Node(data);
		newNode.nextNode = prevNode.nextNode;
		prevNode.nextNode = newNode;		
	}

	private Node getNode(int index) {
		Node returnNode = first.nextNode;
		for (int i = 0; i < index; i++) {
			returnNode = returnNode.nextNode;
		}
		System.out.println("getNode Data : " + returnNode.data);
		return returnNode;
	}

	private void printList() {
		Node node = new Node();
		node = first.nextNode;

		while (node != null) {
			System.out.println(node.data);
			node = node.nextNode;
		}

		System.out.println("first : " + first.nextNode.data);
		System.out.println("last : " + last.nextNode.data);
	}

	public class Node {
		Object data;
		Node nextNode;

		public Node() {
		}

		public Node(Object data) {
			this.data = data;
		}
	}
}
