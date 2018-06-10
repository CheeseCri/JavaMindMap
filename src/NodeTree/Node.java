package NodeTree;

import java.util.ArrayList;

public class Node {
		private String name;
		private int x;
		private int y;
		private int w;
		private int h;
		private String color;
		private Node parent;
		private ArrayList<Node> children;
		
		public Node(String name) {
			this.name = name;
			x = -1;
			y = -1;
			w = -1;
			h = -1;
			color = "FFFFFF";
		}
		
		public Node add(String name) {
			Node childNode = new Node(name);
			childNode.parent = this;
			children.add(childNode);
			return childNode;
		}
}
