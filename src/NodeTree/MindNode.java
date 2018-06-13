package NodeTree;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.border.SoftBevelBorder;

public class MindNode extends JLabel{
	private Node node;
	private Node parentNode;
	
	public MindNode() {
		this.node = null;
	}
	
	public MindNode(Node node) {
		super();
		this.node = node;
		super.setText(node.getName());
		super.setLocation(this.node.getX(), this.node.getY());
		super.setSize(this.node.getW(), this.node.getH());
		super.setOpaque(true);
		super.setBackground(new Color(Integer.parseInt(node.getColor(),16)));
		super.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
		super.setHorizontalAlignment(CENTER);
		System.out.println(super.getBounds());
		this.parentNode = node.getParent();
		
		
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public Node getParentNode() {
		return parentNode;
	}

	public void setParentNode(Node parentNode) {
		this.parentNode = parentNode;
	}
	
	
	
}
