package weichhart.georg.avlTree;

import weichhart.georg.tree.AbstractTreeNode;
import weichhart.georg.tree.TreeNode;

/**
 * 
 * https://en.wikipedia.org/wiki/AVL_tree
 * 
 * In computer science, an AVL tree (named after inventors Adelson-Velsky and Landis) is a self-balancing binary search tree. 
 * It was the first such data structure to be invented.[2] In an AVL tree, the heights of the two child subtrees of any node differ by at most one; 
 * if at any time they differ by more than one, rebalancing is done to restore this property. Lookup, insertion, and deletion all take O(log n) 
 * time in both the average and worst cases, where n is the number of nodes in the tree prior to the operation. 
 * Insertions and deletions may require the tree to be rebalanced by one or more tree rotations.
 * @author gweich
 *
 */
public class AVLTree extends TreeNode {
	
	public AVLTree(int Value) {
		super(Value);
	}
	
	public AVLTree(int Value, AbstractTreeNode Left, AbstractTreeNode Right) {
		super(Value, Left, Right);
	}

	public TreeNode add(TreeNode newN) {
		TreeNode parent = super.add(newN);
		if(parent != AbstractTreeNode.NullNode) {
			AbstractTreeNode grandparent = getParent(parent);
			if(grandparent != AbstractTreeNode.NullNode) {
				int parentBalance = parent.getBalance();
				int grandparentBalance = grandparent.getBalance();
				
				if(grandparentBalance > 1) {
					//not balanced
					// rotate left
					if(parentBalance >= 0) {
						parent = rotateLeft((TreeNode)grandparent);
					} else {
						rotateRight(parent,grandparent);
						parent = rotateLeft((TreeNode)grandparent);
					}
					
				} else if(grandparentBalance < -1) {
					//not balanced
					if(parentBalance <= 0) {
						parent = rotateRight((TreeNode)grandparent);
					} else {
						rotateLeft(parent,grandparent);
						parent = rotateRight((TreeNode)grandparent);
					}
				} else {
					return (TreeNode)grandparent;
				}
			}
		}
		return parent;
	}
	
	/**
	 * 
	 * @param root
	 * @return new root node; if return == root then nothing has happened
	 */
	public TreeNode rotateLeft(TreeNode root) {
		return rotateLeft(root,getParent(root));
	}
	/**
	 * 
	 * @param root
	 * @param parent
	 * @return  new root node; if return == root then nothing has happened
	 */
	public TreeNode rotateLeft(TreeNode root, AbstractTreeNode parent) {
		if(root.getRight()!=AbstractTreeNode.NullNode) {
			TreeNode pivot = (TreeNode)root.getRight();
			root.setRight(pivot.getLeft());
			pivot.setLeft(root);
			
			if(parent!=AbstractTreeNode.NullNode)
				if (((TreeNode)parent).getLeft()==root)
					((TreeNode)parent).setLeft(pivot);
				else if (((TreeNode)parent).getRight()==root)
					((TreeNode)parent).setRight(pivot);
			return pivot;			
		}
		return root;
	}

	/**
	 * 
	 * @param root
	 * @return  new root node; if return == root then nothing has happened
	 */
	public TreeNode rotateRight(TreeNode root) {
		return rotateRight(root,getParent(root));
	}
	
	/**
	 * 
	 * @param root
	 * @param parent
	 * @return  new root node; if return == root then nothing has happened
	 */
	public TreeNode rotateRight(TreeNode root, AbstractTreeNode parent) {
		if(root.getLeft()!=AbstractTreeNode.NullNode) {
			TreeNode pivot = (TreeNode)root.getLeft();
			root.setLeft(pivot.getRight());
			pivot.setRight(root);
			
			if(parent!=AbstractTreeNode.NullNode)
				if (((TreeNode)parent).getLeft()==root)
					((TreeNode)parent).setLeft(pivot);
				else if (((TreeNode)parent).getRight()==root)
					((TreeNode)parent).setRight(pivot);
			return pivot;
		}
		return root;
	}
	
}
