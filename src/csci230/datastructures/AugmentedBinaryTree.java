/**
 * A class that augments the LinkedBinaryTree from the course primary textbook. Instead of <i>directly</i> modifying the LinkedBinaryTree class, we can simply extend the class and
 * exploit the "is-a" relationship.
 */
public class AugmentedBinaryTree<E> extends LinkedBinaryTree<E> {

	
	/**
	 * Removes t he entire subtree rooted at position p, making sure to maintain an accurate count of the size of the tree. <b>Hint</b>: Use recursion. Reference to the remove method
	 * to see how to remove a node but do not use this method.
	 * @param p
	 */
	public void pruneSubtree(Position<E> p) {
				
	}
	
	/**
	 * Restructures the tree so that the node referenced by p takes the place of the node referenced by q, and vice versa. Make sure to properly handle the case when the nodes are
	 * adjacent
	 * @param p
	 * @param q
	 */
	public void swap(Position<E> p, Position<E> q) {
		
		Node<E> posA = validate(p);
		Node<E> parentA = posA.getParent();
		
		Node<E> posB = validate(q);
		Node<E> parentB = posB.getParent();
		// ...
		parentA.setLeft(posB); // maybe parentA.setRight(posB)
		

		
	}
	
	public static void main(String[] args) {}
}