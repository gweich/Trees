package weichhart.georg.network;

import java.util.LinkedList;

public class Edge extends AbstractEdge {

	protected int Weight = Integer.MAX_VALUE;
	protected AbstractNode To = AbstractNode.TERMINAL_NODE;

	public StringBuilder toStringBuilder(LinkedList<AbstractNode> observed) {
		// System.out.println("-E"+Weight+"-");
		StringBuilder sb = new StringBuilder(Integer.toString(Weight));
		if (getTo() != AbstractNode.TERMINAL_NODE) {
			sb.append("->");
			sb.append(getTo().toStringBuilder(observed));
		}
		return sb;
	}

	@Override
	public int getWeight() {
		return Weight;
	}

	public void setWeight(int weight) {
		Weight = weight;
	}

	@Override
	public AbstractNode getTo() {
		return To;
	}

	public void setTo(Node to) {
		To = to;
	}

}
