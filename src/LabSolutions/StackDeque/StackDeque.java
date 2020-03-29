package LabSolutions.StackDeque;

import net.datastructures.ArrayStack;
import net.datastructures.Deque;

/**
 * Class <b>StackDeque</b> is a solution to <b>Lab: StackDeque</b> which challenges students to use a pair of array-based Stacks to
 * implement a Deque.
 * @author Frank Madrid
 *
 * @param <E>
 */
public class StackDeque<E> implements Deque<E> {

	ArrayStack<E> frontStack;
	ArrayStack<E> backStack;
	
	public StackDeque() { this(10); }
	
	public StackDeque(int size) {
		frontStack = new ArrayStack<E>(size);
		backStack  = new ArrayStack<E>(size);
	}

	// Shift all elements from frontStack to backStack
	private void shiftBack() {
		while(!frontStack.isEmpty() && frontStack.top() != null) { backStack.push(frontStack.pop()); }
	}
	
	// Shift all elements from backStack back to frontStack
	private void shiftFront() {
		while(!backStack.isEmpty() && backStack.top() != null) frontStack.push(backStack.pop());
	}
	
	
	@Override
	public int size() { return frontStack.size(); }

	@Override
	public boolean isEmpty() { return size() == 0; }

	@Override
	public E first() {
		
		shiftBack();
		E ret = backStack.top(); // Save the top element of backStack
		shiftFront();
				
		return ret;
	}

	@Override
	public E last() { return frontStack.top(); }

	@Override
	public void addFirst(E e) {
		shiftBack();
		backStack.push(e);
		shiftFront();
	}

	@Override
	public void addLast(E e) { frontStack.push(e);}

	@Override
	public E removeFirst() {
		shiftBack();
		E ret = backStack.pop(); // Save the top element of backStack
		shiftFront();
				
		return ret;
	}
	
	@Override
	public String toString() {
		shiftBack();
		
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		
		// Shift all elements from backStack back to frontStack
		while(!backStack.isEmpty() && backStack.top() != null) {
			E temp = backStack.top();
			sb.append(" " + temp.toString());
			frontStack.push(backStack.pop());
		}
		
		sb.append(" ]");
		return sb.toString();
	}
	
	@Override
	public E removeLast() {
		return frontStack.pop();
	}
}
