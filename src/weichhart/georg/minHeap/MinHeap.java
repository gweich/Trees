package weichhart.georg.minHeap;

import java.util.ArrayList;

import weichhart.georg.network.AbstractEdge;
import weichhart.georg.network.AbstractNode;
import weichhart.georg.network.Node;

public class MinHeap {

	ArrayList<Node> nodes = new ArrayList<>();

	protected void swap(int i, int ii) {
		Node I = nodes.get(i);
		Node II = nodes.get(ii);
		nodes.set(i, II);
		nodes.set(ii, I);
	}

	public int getIdx(Node n) {
		return nodes.indexOf(n);
	}

	public void addNodes(Node n) {
		if (insert(n))
			for (AbstractEdge nxt : n.getEdgesTo()) {
				addNodes((Node)nxt.getTo());
			}
	}

	protected boolean insert(Node n) {
		if (nodes.contains(n))
			return false;

		nodes.add(n);
		int i = nodes.size() - 1;
		while (i > 0 && nodes.get(parent(i)).getPathValue() > nodes.get(i).getPathValue()) {
			swap(i, parent(i));
			i = parent(i);
		}
		return true;
	}

	public boolean isEmpty() {
		return nodes.isEmpty();
	}

	public AbstractNode extractMin() {
		if (nodes.size() == 0)
			return AbstractNode.TERMINAL_NODE;
		if (nodes.size() == 1)
			return nodes.remove(0);

		Node root = nodes.get(0);
		nodes.set(0, nodes.remove(nodes.size() - 1));
		heapify(0);
		return root;
	}

	public void update(Node n) {
		int i = getIdx(n);
		if (nodes.get(parent(i)).getPathValue() > nodes.get(i).getPathValue()) {
			while (i != 0 && nodes.get(parent(i)).getPathValue() > nodes.get(i).getPathValue()) {
				swap(i, parent(i));
				i = parent(i);
			}
		} else {
			heapify(i);
		}
	}

	protected void heapify(int i) {
		int l = leftChild(i);
		int r = rightChild(i);
		int smallest = i;
		if (l < nodes.size() && nodes.get(l).getPathValue() < nodes.get(smallest).getPathValue())
			smallest = l;
		if (r < nodes.size() && nodes.get(r).getPathValue() < nodes.get(smallest).getPathValue())
			smallest = r;
		if (smallest != i) {
			swap(i, smallest);
			heapify(smallest);
		}

	}

	public int parent(int i) {
		return (i - 1) / 2;
	}

	public int leftChild(int i) {
		return (2 * i) + 1;
	}

	public int rightChild(int i) {
		return (2 * i) + 2;
	}

}
