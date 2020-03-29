package csci230.datastructures;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph<E> {

	public static void main(String [] args) {
		
		int[][] adjacencyMatrix = {
				{0,1,1,1,0,0},
				{1,0,1,0,1,0},
				{1,1,0,0,0,0},
				{1,0,0,0,1,1},
				{0,1,0,1,0,1},
				{0,0,0,1,1,0}
			};
		
		System.out.println(adjacencyMatrix);
		
		
		ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<ArrayList<Integer>>(7);
		adjacencyList.set(0, null);
		adjacencyList.set(1, new ArrayList<Integer>(Arrays.asList(2,3,4)));
		adjacencyList.set(2, new ArrayList<Integer>(Arrays.asList(1,3,5)));
		adjacencyList.set(3, new ArrayList<Integer>(Arrays.asList(1,2)));
		adjacencyList.set(4, new ArrayList<Integer>(Arrays.asList(1,5,6)));
		adjacencyList.set(5, new ArrayList<Integer>(Arrays.asList(2,4,6)));
		adjacencyList.set(6, new ArrayList<Integer>(Arrays.asList(4,5)));
	}
	
}
