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
	 * @param newN new node to be inserted
	 * @return parent of newN
	 */
	public TreeNode add(TreeNode newN) {
		if(newN.Value > this.Value) {
			if(this.Right == AbstractTreeNode.NullNode) {
				setRight(newN);
				return this;
			} else {
				TreeNode parent = ((TreeNode)getRight()).add(newN);
				if(parent != this)
					setRight(parent);
				return parent;
			}
		} else {
			if(this.Left == AbstractTreeNode.NullNode) {
				setLeft(newN);
				return this;
			} else {
				TreeNode parent = ((TreeNode)this.Left).add(newN);
				if(parent!=this)
					setLeft(parent);
				return parent;
			}
		}
	}
	
	public AbstractTreeNode getParent(AbstractTreeNode child) {
		if(getLeft()==child || getRight()==child)
			return this;
		AbstractTreeNode res = AbstractTreeNode.NullNode;
	
		if(getLeft()!=AbstractTreeNode.NullNode)
			res = ((TreeNode)getLeft()).getParent(child);
		if(res==AbstractTreeNode.NullNode && getRight()!=AbstractTreeNode.NullNode)
			res = ((TreeNode)getRight()).getParent(child);
		return res;
	}
	
	public boolean isLeave() {
		return this.Left == AbstractTreeNode.NullNode && this.Right == AbstractTreeNode.NullNode;
	}
	
	@Override
	public int getHeight() {
		return Math.max(this.Left.getHeight(), this.Right.getHeight()) + 1 ; 
	}
	
	/**
	 * @return  right.height - left.height 
	 */
	@Override
	public int getBalance() {
		return Right.getHeight() - Left.getHeight();
	}

	public boolean isBST() {
		return isBST(Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	
	public boolean isBST(int smaller, int higher) {
		if(this.Value > smaller && this.Value <= higher)
			return Left.isBST(smaller, this.Value) && Right.isBST(this.Value, higher);
		return false;
	}

	/** 
	 * 
	 * @param Right
	 * @return  old value for Right
	 */
	public AbstractTreeNode setRight (AbstractTreeNode Right) {
		AbstractTreeNode result = this.Right;
		this.Right = Right;
		return result;
	}

	/**
	 * 
	 * @param Left
	 * @return old Value for left
	 */
	public AbstractTreeNode setLeft(AbstractTreeNode Left) {
		AbstractTreeNode result = this.Left;
		this.Left = Left;
		return result;
	}
	public AbstractTreeNode getLeft() {
		return this.Left;
	}
	public AbstractTreeNode getRight() {
		return this.Right;
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder ();
		result.append("[").append(Left.toString()).append("<-").append(this.Value).append("->").append(Right.toString()).append("]");
		return result.toString();
	}
}
