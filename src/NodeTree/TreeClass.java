package NodeTree;

import java.util.ArrayList;

public class TreeClass {
	private Node cur;
	private Node parent; // root
	
	public TreeClass(String name) {
		parent = new Node(name, 0);
	}

	public Node searchNodeById(int id) {
		if(id == 0) return parent;
		for(Node temp : parent.getChildren()) {
			if(temp.getId() == id)
				return temp;
			else if(temp.getChildren().size() != 0)
				return searchNodeById(temp, id);
		}
		return null;
		
	}
	private Node searchNodeById(Node node, int id) {
		if(node.getId() == id)
			return node;
		if(node.getChildren().size() != 0 ) {
			for(Node temp : node.getChildren()) {
				return searchNodeById(temp, id);
			}
		}
		return null;
	}
	
	public void print(int depth) {
		System.out.println("detph = " + depth + " " + parent);
		for(Node temp : parent.getChildren()) {
			print(temp, depth +1);
		}
	}
	
	private void print(Node node, int depth) {
		System.out.println("depth = " + depth +" " + node);
		if(node.getChildren().size() != 0) {
			for(Node temp : node.getChildren()) {
				print(temp, depth + 1);
			}
		}
	}
	
	public Node getCur() {
		return cur;
	}


	public void setCur(Node cur) {
		this.cur = cur;
	}


	public Node getParent() {
		return parent;
	}


	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	
	
	
}
