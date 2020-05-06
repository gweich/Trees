package weichhart.georg.tree;

public class TreeNode extends AbstractTreeNode {

	protected AbstractTreeNode Left;
	protected AbstractTreeNode Right;
	
	protected int Value = Integer.MIN_VALUE;
	
	public TreeNode(int Value) {
		this(Value, AbstractTreeNode.NullNode,AbstractTreeNode.NullNode);
	}
	
	public TreeNode(int Value, AbstractTreeNode Left, AbstractTreeNode Right) {
		this.Left = Left; 
		this.Right = Right;
		this.Value = Value;
	}
	
	
	/**
	 * append a node in the free spot (maintaining Value > this.Value => go Right; else go Left), replacing a NullNode. 
	 *  overwrite if you want to balance this tree.
	 * @param newN
	 */
	public void add(TreeNode newN) {
		if(newN.Value > this.Value) {
			if(this.Right == AbstractTreeNode.NullNode) {
				setRight(newN);
			} else {
				((TreeNode)this.Right).add(newN);
			}
		} else {
			if(this.Left == AbstractTreeNode.NullNode) {
				setLeft(newN);
			} else {
				((TreeNode)this.Left).add(newN);
			}
		}
	}
	
	public boolean isLeave() {
		return this.Left == AbstractTreeNode.NullNode && this.Right == AbstractTreeNode.NullNode;
	}
	
	public int getHeight() {
		return Math.max(this.Left.getHeight(), this.Right.getHeight()) + 1 ; 
	}

	public boolean isBST() {
		return isBST(Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	
	public boolean isBST(int smaller, int higher) {
		if(this.Value > smaller && this.Value <= higher)
			return Left.isBST(smaller, this.Value) && Right.isBST(this.Value, higher);
		return false;
	}

	public AbstractTreeNode setRight (AbstractTreeNode Right) {
		AbstractTreeNode result = this.Right;
		this.Right = Right;
		return result;
	}

	public AbstractTreeNode setLeft(AbstractTreeNode Left) {
		AbstractTreeNode result = this.Left;
		this.Left = Left;
		return result;
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder ();
		result.append("[").append(Left.toString()).append("<-").append(this.Value).append("->").append(Right.toString()).append("]");
		return result.toString();
	}
}
