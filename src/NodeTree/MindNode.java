package NodeTree;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.border.SoftBevelBorder;

import controller.DrawArrow;

public class MindNode extends JLabel {
	private Node node;
	private Node parentNode;
	private double cX, cY, pX, pY;
	private DrawArrow drawArrow;

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
		super.setBackground(new Color(Integer.parseInt(node.getColor(), 16)));
		super.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
		super.setHorizontalAlignment(CENTER);
		this.parentNode = node.getParent();
		if (parentNode != null) {
			this.getShort();
			drawArrow = new DrawArrow(cX, cY, pX, pY);
		}
	}

	public void Draw() {
		if (parentNode != null) {
			// if (super.getParent().getComponents() != null ||
			// super.getParent().getComponents().length != 0) {
			for (Component tmp : super.getParent().getComponents()) {
				if (tmp.getName() == null || tmp.getName().equals(""))
					continue;
				for (Node child : node.getChildren()) {
					if (tmp.getName().equals(child.getId() + "")) {
						MindNode h = (MindNode) tmp;
						h.Draw();
					}
				}
			}
			// }
			this.getShort();
			super.getParent().remove(drawArrow);
			drawArrow = new DrawArrow(cX, cY, pX, pY);
			super.getParent().add(drawArrow);
		}
		else
			for (Component tmp : super.getParent().getComponents()) {
				if (tmp.getName() == null || tmp.getName().equals(""))
					continue;
				for (Node child : node.getChildren()) {
					if (tmp.getName().equals(child.getId() + "")) {
						MindNode h = (MindNode) tmp;
						h.Draw();
					}
				}
			}
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

	public DrawArrow getDrawArrow() {
		return drawArrow;
	}

	public double getDistance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(Math.abs(x2 - x1), 2) + Math.pow(Math.abs(y2 - y1), 2));
	}

	public void getShort() {

		double min = 999999999;

		double pX = this.parentNode.getX();
		double pY = this.parentNode.getY();
		double pW = this.parentNode.getW();
		double pH = this.parentNode.getH();

		double cX = this.node.getX();
		double cY = this.node.getY();
		double cW = this.node.getW();
		double cH = this.node.getH();

		double pUpX = pX + pW / 2;
		double pUpY = pY;

		double pRightX = pX + pW;
		double pRightY = pY + pH / 2;

		double pLeftX = pX;
		double pLeftY = pY + pH / 2;

		double pDownX = pX + pW / 2;
		double pDownY = pY + pH;

		double cUpX = cX + cW / 2;
		double cUpY = cY;

		double cRightX = cX + cW;
		double cRightY = cY + cH / 2;

		double cLeftX = cX;
		double cLeftY = cY + cH / 2;

		double cDownX = cX + cW / 2;
		double cDownY = cY + cH;
		// 1번 case
		if (min > getDistance(cUpX, cUpY, pUpX, pUpY)) {
			this.cX = cUpX;
			this.cY = cUpY;
			this.pX = pUpX;
			this.pY = pUpY;
			min = getDistance(cUpX, cUpY, pUpX, pUpY);
		}

		if (min > getDistance(cUpX, cUpY, pDownX, pDownY)) {
			this.cX = cUpX;
			this.cY = cUpY;
			this.pX = pDownX;
			this.pY = pDownY;
			min = getDistance(cUpX, cUpY, pDownX, pDownY);
		}

		if (min > getDistance(cUpX, cUpY, pLeftX, pLeftY)) {
			this.cX = cUpX;
			this.cY = cUpY;
			this.pX = pLeftX;
			this.pY = pLeftY;
			min = getDistance(cUpX, cUpY, pLeftX, pLeftY);
		}

		if (min > getDistance(cUpX, cUpY, pRightX, pRightY)) {
			this.cX = cUpX;
			this.cY = cUpY;
			this.pX = pRightX;
			this.pY = pRightY;
			min = getDistance(cUpX, cUpY, pRightX, pRightY);
		}
		// 2번 케이스
		if (min > getDistance(cDownX, cDownY, pUpX, pUpY)) {
			this.cX = cDownX;
			this.cY = cDownY;
			this.pX = pUpX;
			this.pY = pUpY;
			min = getDistance(cDownX, cDownY, pUpX, pUpY);
		}

		if (min > getDistance(cDownX, cDownY, pDownX, pDownY)) {
			this.cX = cDownX;
			this.cY = cDownY;
			this.pX = pDownX;
			this.pY = pDownY;
			min = getDistance(cDownX, cDownY, pDownX, pDownY);
		}

		if (min > getDistance(cDownX, cDownY, pLeftX, pLeftY)) {
			this.cX = cDownX;
			this.cY = cDownY;
			this.pX = pLeftX;
			this.pY = pLeftY;
			min = getDistance(cDownX, cDownY, pLeftX, pLeftY);
		}

		if (min > getDistance(cDownX, cDownY, pRightX, pRightY)) {
			this.cX = cDownX;
			this.cY = cDownY;
			this.pX = pRightX;
			this.pY = pRightY;
			min = getDistance(cDownX, cDownY, pRightX, pRightY);
		}
		// 3번 케이스
		if (min > getDistance(cLeftX, cLeftY, pUpX, pUpY)) {
			this.cX = cLeftX;
			this.cY = cLeftY;
			this.pX = pUpX;
			this.pY = pUpY;
			min = getDistance(cLeftX, cLeftY, pUpX, pUpY);
		}

		if (min > getDistance(cLeftX, cLeftY, pDownX, pDownY)) {
			this.cX = cLeftX;
			this.cY = cLeftY;
			this.pX = pDownX;
			this.pY = pDownY;
			min = getDistance(cLeftX, cLeftY, pDownX, pDownY);
		}

		if (min > getDistance(cLeftX, cLeftY, pLeftX, pLeftY)) {
			this.cX = cLeftX;
			this.cY = cLeftY;
			this.pX = pLeftX;
			this.pY = pLeftY;
			min = getDistance(cLeftX, cLeftY, pLeftX, pLeftY);
		}

		if (min > getDistance(cLeftX, cLeftY, pRightX, pRightY)) {
			this.cX = cLeftX;
			this.cY = cLeftY;
			this.pX = pRightX;
			this.pY = pRightY;
			min = getDistance(cLeftX, cLeftY, pRightX, pRightY);
		}

		// 4번 케이스
		if (min > getDistance(cRightX, cRightY, pUpX, pUpY)) {
			this.cX = cRightX;
			this.cY = cRightY;
			this.pX = pUpX;
			this.pY = pUpY;
			min = getDistance(cRightX, cRightY, pUpX, pUpY);
		}

		if (min > getDistance(cRightX, cRightY, pDownX, pDownY)) {
			this.cX = cRightX;
			this.cY = cRightY;
			this.pX = pDownX;
			this.pY = pDownY;
			min = getDistance(cRightX, cRightY, pDownX, pDownY);
		}

		if (min > getDistance(cRightX, cRightY, pLeftX, pLeftY)) {
			this.cX = cRightX;
			this.cY = cRightY;
			this.pX = pLeftX;
			this.pY = pLeftY;
			min = getDistance(cRightX, cRightY, pLeftX, pLeftY);
		}

		if (min > getDistance(cRightX, cRightY, pRightX, pRightY)) {
			this.cX = cRightX;
			this.cY = cRightY;
			this.pX = pRightX;
			this.pY = pRightY;
			min = getDistance(cRightX, cRightY, pRightX, pRightY);
		}

	}

}
