package csci230.datastructures;

import java.util.Arrays;

/* An abstract base class providing some functionality of the Tree interface */
public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {

	/* AbstractBinaryTree specific implementations */
	
	/* Returns the Position of <i>p</i>'s sibling (or null if no sibling exists).*/
	public Position<E> sibling(Position<E> p) {
		if(isRoot(p)) return null;
		return (p == left(parent(p))) ? right(parent(p)) : left(parent(p));
	}
	
	/* Returns an iterable collection of the Positions representing <i>p</i>'s children.*/
	@SuppressWarnings("unchecked")
	public Iterable<Position<E>> children(Position<E> p) {
		return Arrays.asList((Position<E>[])(new Object[] {left(p),right(p)}));
	}
}