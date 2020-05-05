package weichhart.georg.avlTree;

public class AbstractTreeNode {
	
	public static final AbstractTreeNode NullNode = new AbstractTreeNode();
	
	public AbstractTreeNode() {
	}

	public boolean isBST (int smaller, int higher) {
		return true;
	}
	
	public String toString() {
		return "NN";
	}
	
	public int getHeight() {
		return 0;
	}
	
	public static void main(String[] args) {
		
		TreeNode r = new TreeNode(12);
		
		r.addSimple(new TreeNode(9));
		r.addSimple(new TreeNode(8));
		r.addSimple(new TreeNode(10));
		r.addSimple(new TreeNode(25));
		r.addSimple(new TreeNode(24));
		r.addSimple(new TreeNode(8));
		r.addSimple(new TreeNode(20));
		r.addSimple(new TreeNode(26));

		System.out.println(r.toString());
		System.out.println(r.isBST());
		
		r = new TreeNode(10);
		r.addSimple(new TreeNode(9));
		r.addSimple(new TreeNode(8));
		r.addSimple(new TreeNode(7));
		r.addSimple(new TreeNode(6));
		r.addSimple(new TreeNode(5));
		r.addSimple(new TreeNode(4));
		
		System.out.println(r.toString());
		System.out.println(r.isBST());
	}
	
	public static class TreeNode extends AbstractTreeNode {

		AbstractTreeNode Left;
		AbstractTreeNode Right;
		
		int Value = Integer.MIN_VALUE;
		
		public TreeNode(int Value) {
			this(Value, AbstractTreeNode.NullNode,AbstractTreeNode.NullNode);
		}
		
		public TreeNode(int Value, AbstractTreeNode Left, AbstractTreeNode Right) {
			this.Left = Left; 
			this.Right = Right;
			this.Value = Value;
		}
		
		public boolean isLeave() {
			return this.Left == AbstractTreeNode.NullNode && this.Right == AbstractTreeNode.NullNode;
		}
		
		public boolean isBST() {
			return isBST(Integer.MIN_VALUE, Integer.MAX_VALUE);
		}
		
		public int getHeight() {
			return Math.max(this.Left.getHeight(), this.Right.getHeight()) + 1 ; 
		}
		
		public boolean isBST(int smaller, int higher) {
			if(this.Value > smaller && this.Value <= higher)
				return Left.isBST(smaller, this.Value) && Right.isBST(this.Value, higher);
			return false;
		}
		
		public void add(TreeNode newN) {
			addSimple(newN);
			if(this.Left.getHeight() > this.Right.getHeight() +1) {
				//not balanced
				// rotate right
				
				
			} else if(this.Right.getHeight() > this.Left.getHeight() +1) {
				//not balanced
				
				
			}
		}
		
		public void addSimple(TreeNode newN) {
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
}
