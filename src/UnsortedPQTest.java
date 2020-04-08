import java.util.Comparator;

import net.datastructures.Entry;
import net.datastructures.UnsortedPriorityQueue;

public class UnsortedPQTest {

	protected static class ReverseOrder<E> implements Comparator<E> {

		@SuppressWarnings("unchecked")
		@Override
		public int compare(E o1, E o2) {
			return -1 * ((Comparable<E>) o1).compareTo(o2);
		}
		
	}
	
	public static void main(String[] args) {
		
		UnsortedPriorityQueue<String, String> pq = new UnsortedPriorityQueue(new ReverseOrder<String>());
		
		pq.insert("Madrid","Frank");
		pq.insert("Manjarrez", "Alex");
		pq.insert("Bickel", "Daniel");
		pq.insert("Robles", "David");
		pq.insert("Hochhalter","Destiny");
		pq.insert("Bayer","Ethan");
		pq.insert("Limpus","Jonathan");
	
		while(!pq.isEmpty()) {
			Entry<String,String> e = pq.removeMin();
			System.out.println(e.getKey() + " " + e.getValue());
		}
	}
}
