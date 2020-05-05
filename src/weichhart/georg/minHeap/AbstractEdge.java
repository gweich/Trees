package weichhart.georg.minHeap;

import java.util.LinkedList;

import weichhart.georg.minHeap.AbstractNode.TerminalNode;

public interface AbstractEdge {
	public AbstractNode getTo();

	public int getWeight();

	public StringBuilder toStringBuilder(LinkedList<AbstractNode> observed);

	public static final class NoEdge implements AbstractEdge {
		public static final AbstractEdge NO_EDGE = new NoEdge();

		@Override
		public AbstractNode getTo() {
			return TerminalNode.TERMINAL_NODE;
		}

		@Override
		public int getWeight() {
			return Integer.MIN_VALUE;
		}

		@Override
		public StringBuilder toStringBuilder(LinkedList<AbstractNode> observed) {
			return new StringBuilder();
		}
	}

}
