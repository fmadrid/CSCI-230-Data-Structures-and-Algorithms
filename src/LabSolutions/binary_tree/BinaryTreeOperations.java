package LabSolutions.binary_tree;

import java.util.ArrayList;
import net.datastructures.LinkedBinaryTree;
import net.datastructures.Position;

public final class BinaryTreeOperations {

	/**
	 * Builds a binary tree from an arr specified in depth-first search order
	 *               0
	 *         1            2
	 *      3       4        5        6
	 *     7  8   9  10   11   12  13   14
	 * @param <Integer>
	 * @param arr
	 * @return
	 */
	public static LinkedBinaryTree<Integer> buildTree(ArrayList<Integer> arr) {
		return buildsubtree(arr, 0);
	}
	
	public static <Integer> LinkedBinaryTree<Integer> buildsubtree(ArrayList<Integer> arr, int idx) {
		
		if(idx >= arr.size()) return null;
		LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<Integer>();
		tree.attach(tree.addRoot(arr.get(idx)), buildsubtree(arr, idx * 2 + 1),buildsubtree(arr, idx * 2 + 2)); 
		return tree;
	}
	
	public static <Integer> void printTree(LinkedBinaryTree<Integer> tree) {
		printsubtree(tree, tree.root(), 0);
	}
	
	public static <Integer> void printsubtree(LinkedBinaryTree<Integer> tree, Position<Integer> p, int depth) {
		if(p == null) return;
		for(int i = 1; i <= depth; ++i)
			System.out.print("\t");
		System.out.println(p.getElement().toString());
		printsubtree(tree, tree.left(p), depth + 1);
		printsubtree(tree, tree.right(p), depth + 1);
	}

	
}
