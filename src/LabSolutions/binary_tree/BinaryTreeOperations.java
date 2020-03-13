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
	public static <E> LinkedBinaryTree<E> buildTree(ArrayList<E> arr) {
		return buildsubtree(arr, 0);
	}
	
	public static <E> LinkedBinaryTree<E> buildsubtree(ArrayList<E> arr, int idx) {
		
		if(idx >= arr.size()) return null;
		LinkedBinaryTree<E> tree = new LinkedBinaryTree<E>();
		LinkedBinaryTree<E> leftTree = buildsubtree(arr, idx*2+1);
		LinkedBinaryTree<E> rightTree = buildsubtree(arr, idx*2+2);
		
		if(leftTree != null) tree.addLeft(leftTree.root())
		
		tree.attach(tree.addRoot(arr.get(idx)), (arr.get(idx*2+1) == null) ? null : buildsubtree(arr, idx * 2 + 1),buildsubtree(arr, idx * 2 + 2)); 
		return tree;
	}
	
	public static <E> void printTree(LinkedBinaryTree<E> tree) {
		printsubtree(tree, tree.root(), 0);
	}
	
	public static <E> void printsubtree(LinkedBinaryTree<E> tree, Position<E> p, int depth) {
		if(p == null) return;
		for(int i = 1; i <= depth; ++i)
			System.out.print("\t");
		System.out.println(p.getElement().toString());
		printsubtree(tree, tree.left(p), depth + 1);
		printsubtree(tree, tree.right(p), depth + 1);
	}

	
}
