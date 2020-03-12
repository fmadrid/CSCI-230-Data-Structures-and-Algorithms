package LabSolutions.binary_tree;

import java.util.ArrayList;

import net.datastructures.LinkedBinaryTree;

public class BinaryTreeOperationDriver {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		                                              arr.add(1);
		                   arr.add(2);                                       arr.add(3);
		         arr.add(4);    arr.add(null);             arr.add(6);                         arr.add(7);
		arr.add(9);      arr.add(10);           arr.add(null);    arr.add(null);    arr.add(11);
		
		LinkedBinaryTree<Integer> tree = BinaryTreeOperations.buildTree(arr);
		
		BinaryTreeOperations.printTree(tree);
	}
}
