package weichhart.georg.minHeap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public interface AbstractNode {

	public int getPathValue();

	public void setPathValue(int val);

	public List<AbstractEdge> getEdgesTo();

	public String getId();

	public void setSelectedSource(AbstractNode node);

	public AbstractNode getSelectedSource();

	public StringBuilder toStringBuilder(LinkedList<AbstractNode> observed);
	
	public String toResult();

	public static final class TerminalNode implements AbstractNode {

		public static final TerminalNode TERMINAL_NODE = new TerminalNode();
		public final List<AbstractEdge> empty = new ArrayList<>();

		@Override
		public List<AbstractEdge> getEdgesTo() {
			return empty;
		}

		@Override
		public int getPathValue() {
			return Integer.MIN_VALUE;
		}
		
		@Override
		public String getId() {
			return "!";
		}

		@Override
		public void setSelectedSource(AbstractNode node) {
		}

		@Override
		public AbstractNode getSelectedSource() {
			return this;
		}
		
		@Override
		public void setPathValue(int val) {
		}

		@Override
		public StringBuilder toStringBuilder(LinkedList<AbstractNode> observed) {
			observed.add(this);
			return new StringBuilder(getId());
		}
		
		@Override 
		public String toResult() {
			return getId();
		}
	}
}
