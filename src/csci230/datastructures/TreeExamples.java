package csci230.datastructures;

public class TreeExamples {

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
		LinkedBinaryTree<String> tree = new LinkedBinaryTree();
		Position<String> temp = tree.addRoot("Start");
		temp = tree.addLeft(temp, "A");
		tree.addLeft(temp, "C");
		tree.addRight(temp, "B");
		printPreorder(tree);
	}
}
