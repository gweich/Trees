package weichhart.georg.avlTree;

import weichhart.georg.tree.AbstractTreeNode;
import weichhart.georg.tree.TreeNode;

public class AVLTree extends TreeNode {
	
	public AVLTree(int Value) {
		super(Value);
	}
	
	public AVLTree(int Value, AbstractTreeNode Left, AbstractTreeNode Right) {
		super(Value, Left, Right);
	}

	public void add(TreeNode newN) {
		super.add(newN);
		if(Left.getHeight() > Right.getHeight() +1) {
			//not balanced
			// rotate right
			
			
		} else if(Right.getHeight() > Left.getHeight() +1) {
			//not balanced
			
			
		}
	}
}
