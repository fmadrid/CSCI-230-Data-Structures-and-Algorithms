package csci230.datastructures;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BinaryTreeOperations {

	public List<Position<E>> nodesAtDepth(LinkedBinaryTree<E> tree, int depth) {
		
		if(depth == 0) // Add node to list
		else nodesAtDepthRecursive(/*for each child*/, depth - 1)
	}
	
	public static LinkedBinaryTree<String> constructBinaryTree(List<String> preorderTraversal) {
		Iterator<String> it = preorderTraversal.iterator();
		LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();
		if(!it.hasNext()) return tree;
		
		Position<String> subroot = tree.addRoot(it.next());
		
		boolean skipLeft = false;
		while(it.hasNext() && subroot != null) {
			String str = it.next();
			
			if(tree.left(subroot) != null || skipLeft) {
				if(str == null) subroot = tree.parent(subroot);
				else subroot = tree.addRight(subroot, str);
				skipLeft = false;
			} else if(tree.left(subroot) == null && str == null)
				skipLeft = true;
			else if(tree.left(subroot) == null && !skipLeft)
				subroot = tree.addLeft(subroot, str);
		}
		return tree;
	}
	
	public static <E> void printPreorder(LinkedBinaryTree<E> tree ) {
		printPreorderSubtree(tree,tree.root(), 0);
	}
	
	private static <E> void printPreorderSubtree(LinkedBinaryTree<E> tree, Position<E> subroot, int depth) {
		for(int i = 1; i <= depth; ++i) System.out.print("\t");
		System.out.println(subroot.getElement());
		
		if(tree.left(subroot) != null) printPreorderSubtree(tree, tree.left(subroot), depth + 1);
		if(tree.right(subroot) != null) printPreorderSubtree(tree, tree.right(subroot), depth + 1);
		
	}
	public static void main(String[] args) {
		String[] str = new String[] {"1","2",null, null,"3","4",null,null, "5", null, null};
		List<String> list = Arrays.asList(str);
		LinkedBinaryTree<String> tree = constructBinaryTree(list);
		LinkedBinaryTree<String> tree2 = new LinkedBinaryTree<String>();
		
		tree2.addRoot("A");
		tree2.addLeft(tree2.root(), "B");
		
		for(Position<String> s : tree2.positions())
			System.out.print(s.getElement() + " ");
		
		// Print tree
		//for(Position<String> iter : tree.preorder()) {
		//	System.out.print(iter.getElement() + " ");
		//}
		
		//Position<String> p = tree.preorderSearch("5");
		//tree.addRight(p, "0");
	
		//for(Position<String> iter : tree.preorder()) {
		//	System.out.print(iter.getElement() + " ");
		//}
	}
}
