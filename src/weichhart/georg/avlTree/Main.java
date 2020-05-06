package weichhart.georg.avlTree;

import weichhart.georg.tree.TreeNode;

public class Main {

	public static void main(String[] args) {
		
		TreeNode r = new TreeNode(12);
		
		r.add(new TreeNode(9));
		r.add(new TreeNode(8));
		r.add(new TreeNode(10));
		r.add(new TreeNode(25));
		r.add(new TreeNode(24));
		r.add(new TreeNode(8));
		r.add(new TreeNode(20));
		r.add(new TreeNode(26));

		System.out.println(r.toString());
		System.out.println(r.isBST());
		
		r = new TreeNode(10);
		r.add(new TreeNode(9));
		r.add(new TreeNode(8));
		r.add(new TreeNode(7));
		r.add(new TreeNode(6));
		r.add(new TreeNode(5));
		r.add(new TreeNode(4));
		
		System.out.println(r.toString());
		System.out.println(r.isBST());
	}

}
