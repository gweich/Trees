package weichhart.georg.network;

import java.util.LinkedList;

public class AbstractEdge {
	public static final AbstractEdge NO_EDGE = new AbstractEdge();

	public AbstractNode getTo() {
		return AbstractNode.TERMINAL_NODE;
	}

	public int getWeight() {
		return Integer.MIN_VALUE;
	}

	public StringBuilder toStringBuilder(LinkedList<AbstractNode> observed) {
		return new StringBuilder();
	}
}
