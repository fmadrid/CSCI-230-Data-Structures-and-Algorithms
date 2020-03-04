package LabSolutions.DataStructures;

import java.util.LinkedList;
import java.util.Stack;

public class SortedLinkedList<E extends Comparable<E>> extends LinkedList<E> {
	

	public SortedLinkedList() {}
	
	@Override
	public boolean add(E element) {
		
		Stack<E> stack = new Stack<>();
		
		while(!isEmpty()) {
			if(getFirst().compareTo(element) == -1) stack.push(removeFirst());
			else break;
		}
		addFirst(element);
		while(!stack.empty()) addFirst(stack.pop());
		
		return false;
	}
}
