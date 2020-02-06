package LabSolutions.Lists;
import net.datastructures.SinglyLinkedList;
import net.datastructures.CircularlyLinkedList;

public class LinkedListOperations {

	//Algorithm: Reverses the elements of a singly linked list
	public static <E> SinglyLinkedList<E> reverse(SinglyLinkedList<E> list) {
		
		SinglyLinkedList<E> ret = new SinglyLinkedList<>();
		while(!list.isEmpty()) {
			ret.addLast(list.removeFirst());
		}
		
		return ret;
	}
	
	// Unfortunately, this solution will not work if either list contains any characters from the string ",() ".
	public static <E> boolean isEqual(CircularlyLinkedList<E> l1, CircularlyLinkedList<E> l2) {
	
		// If the lists are not the same size, then they cannot contain the same elements
		if(l1.size() != l2.size()) return false;
		if(l1.isEmpty() && l2.isEmpty()) return true;	// If the lists are empty, then no point in checking contents
		
		// Get the string representation of the list removing all commas, whitespace, and parenthesis
		StringBuilder sb = new StringBuilder();
		for(char c : l1.toString().toCharArray())
			if(c != ',' && c != '(' && c != ')' && c != ' ') sb.append(c);
		
		String str1 = sb.toString();

		// Get the string representation of the list+list removing all commas, whitespace, and parenthesis
		sb = new StringBuilder();
		for(char c : (l2.toString() + l2.toString()).toCharArray())
			if(c != ',' && c != '(' && c != ')' && c != ' ') sb.append(c);
		
		String str2 = sb.toString();
		
		// If str2+str2 contains str1, then there is a rotation where str2 = str1
		return str2.contains(str1);
	}
	
	public static void main(String[] args) {
		SinglyLinkedList<Integer> oldList = new SinglyLinkedList<>();
		oldList.addFirst(1); oldList.addFirst(10); oldList.addFirst(3); oldList.addFirst(5);
		
		SinglyLinkedList<Integer> newList = LinkedListOperations.reverse(oldList);
		
		System.out.println("Original List: " + oldList.toString());
		System.out.println("Reversed List: " + newList.toString());
		
		CircularlyLinkedList<Character> list1 = new CircularlyLinkedList<>();
		list1.addLast('a'); list1.addLast('p'); list1.addLast('p'); list1.addLast('l'); list1.addLast('e');
		
		CircularlyLinkedList<Character> list2 = new CircularlyLinkedList<>();
		list2.addLast('l'); list2.addLast('e'); list2.addLast('a'); list2.addLast('p'); list2.addLast('p'); 
		
		System.out.println("List 1: " + list1.toString());
		System.out.println("List 2: " + list2.toString());

		System.out.println("isEqual: " + LinkedListOperations.isEqual(list1, list2));
	}
}

