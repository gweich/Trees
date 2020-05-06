package weichhart.georg.network;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AbstractNode {

	public static final AbstractNode TERMINAL_NODE = new AbstractNode(true);

	protected List<AbstractEdge> EdgesTo;

	protected AbstractNode() {
		this(false);
	}

	private AbstractNode(boolean empty) {
		if (empty)
			EdgesTo = new ArrayList<AbstractEdge>(0);
		else
			EdgesTo = new LinkedList<AbstractEdge>();
	}

	public List<AbstractEdge> getEdgesTo() {
		return EdgesTo;
	}

	public int getPathValue() {
		return Integer.MAX_VALUE;
	}

	public String getId() {
		return "!";
	}

	public String toResult() {
		return "!";
	}
	
	public AbstractNode getSelectedSource() {
		return TERMINAL_NODE;
	}
	
	public String toString() {
		StringBuilder result = toStringBuilder(new LinkedList<AbstractNode>());
		return result.toString();
	}

	public StringBuilder toStringBuilder(LinkedList<AbstractNode> observed) {
		// System.out.println(id);
		StringBuilder sb = new StringBuilder(getId());
		if (!observed.contains(this)) {
			observed.add(this);
			for (AbstractEdge e : getEdgesTo()) {
				if (e != AbstractEdge.NO_EDGE)
					sb.append("-").append(e.toStringBuilder(observed));
			}
		} else
			sb.append("|");
		return sb;
	}
	

}
