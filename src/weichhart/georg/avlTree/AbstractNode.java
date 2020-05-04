package avlTree;

public class AbstractNode {
	
	public static final AbstractNode NullNode = new AbstractNode();
	
	public AbstractNode() {
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
		
		Node r = new Node(12);
		
		r.addSimple(new Node(9));
		r.addSimple(new Node(8));
		r.addSimple(new Node(10));
		r.addSimple(new Node(25));
		r.addSimple(new Node(24));
		r.addSimple(new Node(8));
		r.addSimple(new Node(20));
		r.addSimple(new Node(26));

		System.out.println(r.toString());
		System.out.println(r.isBST());
		
		r = new Node(10);
		r.addSimple(new Node(9));
		r.addSimple(new Node(8));
		r.addSimple(new Node(7));
		r.addSimple(new Node(6));
		r.addSimple(new Node(5));
		r.addSimple(new Node(4));
		
		System.out.println(r.toString());
		System.out.println(r.isBST());
	}
	
	public static class Node extends AbstractNode {

		AbstractNode Left;
		AbstractNode Right;
		
		int Value = Integer.MIN_VALUE;
		
		public Node(int Value) {
			this(Value, AbstractNode.NullNode,AbstractNode.NullNode);
		}
		
		public Node(int Value, AbstractNode Left, AbstractNode Right) {
			this.Left = Left; 
			this.Right = Right;
			this.Value = Value;
		}
		
		public boolean isLeave() {
			return this.Left == AbstractNode.NullNode && this.Right == AbstractNode.NullNode;
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
		
		public void add(Node newN) {
			addSimple(newN);
			if(this.Left.getHeight() > this.Right.getHeight() +1) {
				//not balanced
				// rotate right
				
			} else if(this.Right.getHeight() > this.Left.getHeight() +1) {
				//not balanced
				
			}
		}
		
		public void addSimple(Node newN) {
			if(newN.Value > this.Value) {
				if(this.Right == AbstractNode.NullNode) {
					setRight(newN);
				} else {
					((Node)this.Right).add(newN);
				}
			} else {
				if(this.Left == AbstractNode.NullNode) {
					setLeft(newN);
				} else {
					((Node)this.Left).add(newN);
				}
			}
		}
		
		
		
		public AbstractNode setRight (AbstractNode Right) {
			AbstractNode result = this.Right;
			this.Right = Right;
			return result;
		}

		public AbstractNode setLeft(AbstractNode Left) {
			AbstractNode result = this.Left;
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
