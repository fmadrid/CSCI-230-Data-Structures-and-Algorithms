package LabSolutions.binary_tree;

import java.util.ArrayList;

import net.datastructures.LinkedBinaryTree;

public class BinaryTreeOperationDriver {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 0; i < 15; i++) arr.add(null);
		arr.set(0, 0);
		arr.set(1, 1);
		arr.set(2, 2);
		LinkedBinaryTree<Integer> tree = BinaryTreeOperations.buildTree(arr);
		
		BinaryTreeOperations.printTree(tree);
	}
}
