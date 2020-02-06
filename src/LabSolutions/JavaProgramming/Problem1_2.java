package LabSolutions.JavaProgramming;

import java.util.ArrayList;
import java.util.Random;

public class Problem1_2 {

	// Example: LRRRLRRLRRRL
	//				Check all substrings
	//				L, LR, LRR, LRRR, LRRRL, LRRRLR, LRRRLRR, LRRRLRRL, LRRRLRRLR, LRRRLRRLRR, LRRRLRRLRRR, LRRRLRRLRRRL
	//              R, RR, RRR, RRRL, ........, RRLRRLRRRL
	//
	//
	//
	//
	//  n^3 total characters
	
	
	// Checks all substrings and counts the number of L's and R's, if equal save the substring and
	// return this list when finished with some subtle optimizations
	private static ArrayList<String> bruteForceSolution(String str) {
		
		
		// List of balanced substrings
		ArrayList<String> balancedStrings = new ArrayList<>();
		
		// Beginning at each index i
		for(int i = 0; i < str.length(); ++i) {
			
			// For each ending index
			for(int j = i; j < str.length(); ++j) {
			
				// Only even length strings can potentially be balanced
				if((j - i + 1) % 2 == 1) continue;
				
				int LCount = 0;
				int RCount = 0;
				
				for(char c : str.substring(i,j+1).toCharArray()) {
					if(c == 'L')      LCount++;
					else if(c == 'R') RCount++;
				}
				
				if(LCount == RCount) balancedStrings.add(str.substring(i,j));
			}
		}
		
		return balancedStrings;
	}
	
	private static String generateString() {
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		int sz = rand.nextInt(20);
		while(--sz >= 0) {
			if(rand.nextInt(2) == 0) sb.append('L');
			else sb.append('R');
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		String str = generateString();	// Randomly generates a string of L's and R's (20 characters in length)
		
		System.out.println("Sample String: " + str);
		System.out.print("BruteForce Solution: ");
		for(String s : bruteForceSolution(str)) {
			System.out.print(s + " ");
		}
	}
}
