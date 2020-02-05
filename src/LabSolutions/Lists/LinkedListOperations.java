package LabSolutions.Lists;
import net.datastructures.SinglyLinkedList;

public class LinkedListOperations {

	//Algorithm: Reverses the elements of a singly linked list
	public static <E> SinglyLinkedList<E> reverse(SinglyLinkedList<E> list) {
		
		// list is an instance of a SinglyLinkedList with some number of nodes
		// 1 -> 10 -> 3 -> 5
		// Objective: return a NEW singlylinkedList with the nodes 5 -> 3 -> 10 ->1
		
		SinglyLinkedList<E> ret = new SinglyLinkedList<>();
		
		// Add things to ret
		
		
		
		return ret;
	}
	
	public static void main(String[] args) {
		SinglyLinkedList<Integer> oldList = new SinglyLinkedList<>();
		oldList.addFirst(1); oldList.addFirst(10); oldList.addFirst(3); oldList.addFirst(5);
		
		SinglyLinkedList<Integer> newList = LinkedListOperations.reverse(oldList);
		
		System.out.println("Original List: " + oldList.toString());
		System.out.println("Reversed List: " + newList.toString());
	}
}
