package weichhart.georg.avlTree;

import weichhart.georg.tree.TreeNode;

public class Main {

	public static void main(String[] args) {
		
		TreeNode r = new AVLTree(12);
		
		r = r.add(new AVLTree(9));
		r = r.add(new AVLTree(8));
		r = r.add(new AVLTree(10));
		r = r.add(new AVLTree(25));
		r = r.add(new AVLTree(24));
		r = r.add(new AVLTree(8));
		r = r.add(new AVLTree(20));
		r = r.add(new AVLTree(26));

		System.out.println(r.toString());
		System.out.println(r.isBST());
		
		r = new AVLTree(10);
		r = r.add(new AVLTree(9));
		r = r.add(new AVLTree(8));
		r = r.add(new AVLTree(7));
		r = r.add(new AVLTree(6));
		r = r.add(new AVLTree(5));
		r = r.add(new AVLTree(4));
		
		System.out.println(r.toString());
		System.out.println(r.isBST());
	}

}
