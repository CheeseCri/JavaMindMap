package NodeTree;

import java.util.ArrayList;

public class Node {
		private String name;
		private int x;
		private int y;
		private int w;
		private int h;
		private String color;
		private transient Node parent;
		private int id;
		private ArrayList<Node> children;
		
		public Node(String name, int id) {
			this.name = name;
			x = -1;
			y = -1;
			w = 40;
			h = 20;
			color = "FFFFFF";
			this.id = id;
			this.children = new ArrayList<Node>();
		}
		
		public Node(String name, int id, int x, int y) {
			this.name = name;
			this.x = x;
			this.y = y;
			w = 40;
			h = 20;
			color = "FFFFFF";
			this.id = id;
			this.children = new ArrayList<Node>();
		}
		
		public Node add(String name, int id) {
			Node childNode = new Node(name, id);
			childNode.parent = this;
			children.add(childNode);
			return childNode;
		}

		public String toString() {
			return "id = " + this.id +
					" string = " + this.name + " " + this.children;
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getW() {
			return w;
		}

		public void setW(int w) {
			this.w = w;
		}

		public int getH() {
			return h;
		}

		public void setH(int h) {
			this.h = h;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public ArrayList<Node> getChildren() {
			return children;
		}

		public void setChildren(ArrayList<Node> children) {
			this.children = children;
		}
		
		
}
