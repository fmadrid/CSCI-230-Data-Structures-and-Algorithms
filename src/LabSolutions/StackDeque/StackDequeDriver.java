package LabSolutions.StackDeque;

public class StackDequeDriver {

	private static StackDeque<Integer> s = new StackDeque<Integer>(10);
	
	public static void reset() {
		System.out.println("[reset]: Resetting Stack");
		while(!s.isEmpty()) s.removeLast();
	}
	
	public static void size() { System.out.println("[size] " + s.size()); }
	
	public static void first() { System.out.println("[first]: " + s.first()); }
	
	public static void last() { System.out.println("[last]: " + s.last()); }
	
	public static void removeFirst() { System.out.println("[removeFirst]: " + s.removeFirst()); }
	
	public static void removeLast() { System.out.println("[removeLast]: " + s.removeLast()); }
	
	public static void addFirst(Integer i) {
		
		System.out.println("[addFirst]: Adding element " + i);
		s.addFirst(i);
	}
	
	public static void addLast(Integer i) {
		
		System.out.println("[addLast]: Adding element " + i);
		s.addLast(i);
	}

	public static void printStack() {
		System.out.println("Stack: " + s.toString());
	}
	
	public static void main(String[] args) {

		// Empty Stack
		printStack();
		size();
		first();
		removeFirst();
		removeLast();
		addFirst(1);
		printStack();
		addLast(2);
		printStack();
		removeFirst();
		printStack();
	}

}
