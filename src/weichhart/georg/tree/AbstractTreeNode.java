package weichhart.georg.tree;

public class AbstractTreeNode {
	
	public static final AbstractTreeNode NullNode = new AbstractTreeNode();

	protected AbstractTreeNode() {
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
	
	/**
	 * 
	 * @return  right.height - left.height
	 */
	public int getBalance() {
		return 0;
	}

}
