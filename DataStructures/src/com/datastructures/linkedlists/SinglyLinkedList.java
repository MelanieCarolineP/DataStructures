package com.datastructures.linkedlists;

public class SinglyLinkedList {
	
	private class Node {
		int value;
		Node next;
		Node(int val){
			value = val;
		}	
	}
	
	Node head = null;
	int length = 0;
	
	/* Methods */
	/** Adds a value at the head of the linked list
	 * 
	 * @param value
	 */
	void appendAtHead(int value) {
		Node newHead = new Node(value);
		newHead.next = head;
		head = newHead;
		length++;
	}
	void appendAtTail(int value) {
		insertAt(length - 1, value);
	}
	/** Adds a value to an existing place in the list
	 * 
	 * @param index (zero-indexing)
	 * @param value
	 */
	void insertAt(int index, int value) {
		Node newNode = new Node(value);
		Node curNode = head;
		for (int i = 0; i < index; i++) {
			curNode = curNode.next;
		}
		newNode.next = curNode.next;
		curNode.next = newNode;
		length++;
	}
	/** 
	 * Deletes first entry 
	 */
	void deleteHead() {
		head = head.next;
		length--;
	}
	/** 
	 * Deletes last entry 
	 */
	void deleteTail() {
		deleteAt(length - 1);
		length--;
	}
	/** Deletes the entry at the specified location, zero-indexing
	 * 
	 * @param index
	 */
	void deleteAt(int index) {
		Node curNode = head;
		for (int i = 0; i < index; i++) {
			curNode = curNode.next;
		}
		curNode.next = curNode.next.next;
		length--;
	}
	
	
	//retrieval methods
	/** Length of list 
	 * 
	 * @return the size of the list
	 */
	int length() {
		return length;
	}
	
	//other fun methods ex. shifting to right
	/** 
	 * prints list in string format
	 */
	void print() {
		StringBuilder str = new StringBuilder("[ ");
		Node curNode = head;
		for (int i = 0; i < length; i++) {
			str.append(String.valueOf(curNode.value));
			curNode = curNode.next;
			if (i != length - 1) {
				str.append(", ");
			}
		}
		str.append(" ]");
		System.out.println(str);
	}
	

	public static void main(String[] args) {
		SinglyLinkedList ll = new SinglyLinkedList();
		ll.appendAtHead(8);
		ll.appendAtHead(1);
		ll.insertAt(1,3);
		ll.print();
		System.out.println("length is: " + ll.length());
		ll.deleteAt(1);
		ll.print();
		ll.appendAtTail(5);
		ll.appendAtTail(10);
		ll.insertAt(2, 17);
		ll.print();
		System.out.println("length is: " + ll.length());
		ll.deleteHead();
		ll.print();
		System.out.println("length is: " + ll.length());

	}

}
