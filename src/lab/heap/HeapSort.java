package lab.heap;

import java.util.Random;

import net.datastructures.HeapPriorityQueue;
import net.datastructures.LinkedPositionalList;
import net.datastructures.PositionalList;
import net.datastructures.PriorityQueue;

public class AbstractTree<E> implements AbstractDirectGraph<E> { ... }

	
	/** Sorts sequence S, using initially empty priority queue P to produce the order. */
	public static <E> void pqSort(PositionalList<E> S, PriorityQueue<E, ?> P) {
		int n = S.size();
		for (int j = 0; j < n; j++) {
			E element = S.remove(S.first());
			P.insert(element, null); // element is key; null value
		}
		
		for (int j = 0; j < n; j++) {
			E element = P.removeMin().getKey();
			S.addLast(element); // the smallest key in P is next placed in S
		}
	}
	
	public <K> void sortInPlace(PositionalList<K> S) {
		// COMPLETE THIS METHOD
		  
	  }
	
	public static void main(String[] args) {
		LinkedPositionalList<Integer> list = new LinkedPositionalList<Integer>();
		HeapPriorityQueue<Integer, Integer> heap = new HeapPriorityQueue<Integer, Integer>();
		
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		for (int i = 0; i < 10; ++i) {
			list.addLast(rand.nextInt(100));
		}
		
		System.out.println("Original Sequence:");
		for (int num : list) {
			System.out.print(num + " ");
		}
		System.out.println("\n----------");
		
		pqSort(list, heap);
		
		System.out.println("After heap sort...");
		for (int num : list) {
			System.out.print(num + " ");
		}
		System.out.println("\n----------");
		
		LinkedPositionalList<Integer> list2 = new LinkedPositionalList<Integer>();
		MaxHeapPriorityQueue<Integer, Integer> heap2 = new MaxHeapPriorityQueue<Integer, Integer>();
		
		for (int i = 0; i < 10; ++i) {
			list2.addLast(rand.nextInt(100));
		}
		
		System.out.println("Original Sequence:");
		for (int num : list2) {
			System.out.print(num + " ");
		}
		System.out.println("\n----------");
		
		heap2.sortInPlace(list2);
	}
	
}
