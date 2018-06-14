package Listener;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JTextField;

import NodeTree.MindNode;
import NodeTree.Node;

public class MindNodeMouseListener implements MouseListener, MouseMotionListener {
	private static MindNode selectedMindNode;

	private int startX;
	private int startY;
	private int endX;
	private int endY;
	private boolean isDraged;
	private boolean isResize;
	private JTextField settingItemNameEdit;
	private JTextField settingItemXEdit;
	private JTextField settingItemYEdit;
	private JTextField settingItemWEdit;
	private JTextField settingItemHEdit;
	private JTextField settingItemCEdit;

	public MindNodeMouseListener(JTextField settingItemNameEdit, JTextField settingItemXEdit,
			JTextField settingItemYEdit, JTextField settingItemWEdit, JTextField settingItemHEdit,
			JTextField settingItemCEdit) {
		this.settingItemNameEdit = settingItemNameEdit;
		this.settingItemXEdit = settingItemXEdit;
		this.settingItemYEdit = settingItemYEdit;
		this.settingItemWEdit = settingItemWEdit;
		this.settingItemHEdit = settingItemHEdit;
		this.settingItemCEdit = settingItemCEdit;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (selectedMindNode != null){
			selectedMindNode.setBackground(new Color(Integer.parseInt(selectedMindNode.getNode().getColor(), 16)));
			selectedMindNode.setForeground(new Color(0x000000));
		}
		MindNode source = (MindNode) e.getSource();
		Node node = source.getNode();
		// System.out.println(source.getText());
		setSettingField(node.getName(), node.getX(), node.getY(), node.getW(), node.getH(), node.getColor());

		selectedMindNode = source;
		int rgb = Integer.parseInt(source.getNode().getColor(), 16);
		int red = (rgb & 0xFF0000) >> 16;
		int green = (rgb & 0x00FF00) >> 8;
		int blue = (rgb & 0x0000FF);

		Color reverseColor = new Color(255 - red, 255 - green, 255 - blue);

		// Color reverseColor = Color.MAGENTA;
		selectedMindNode.setBackground(reverseColor);
		selectedMindNode.setForeground(new Color(0xFFFFFF));
		// TODO Auto-generated method stub
	}

	private void setSettingField(String name, int x, int y, int w, int h, String color) {
		settingItemNameEdit.setText(name);
		settingItemXEdit.setText(x + "");
		settingItemYEdit.setText(y + "");
		settingItemWEdit.setText(w + "");
		settingItemHEdit.setText(h + "");
		settingItemCEdit.setText(color);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("PRESS ? Point = " + e.getPoint());

		if (isResize == true) {
			this.startX = e.getXOnScreen();
			this.startY = e.getYOnScreen();
		} else {
			this.startX = e.getX();
			this.startY = e.getY();
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		MindNode thisMindNode = (MindNode) e.getSource();
		Node node = thisMindNode.getNode();
		thisMindNode.Draw();
		endX = e.getX();
		endY = e.getY();

		this.isDraged = false;
		this.isResize = false;
		thisMindNode.setCursor(Cursor.getDefaultCursor());
		thisMindNode.getParent().setVisible(false);
		thisMindNode.getParent().setVisible(true);
		System.out.println("REX = " + endX + " REY = " + endY);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		this.isDraged = true;
		MindNode thisMindNode = (MindNode) e.getSource();
		Node node = thisMindNode.getNode();
		endX = e.getX();
		endY = e.getY();
		if (isResize == false) {
			thisMindNode.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
			node.setX(node.getX() + endX - startX);
			node.setY(node.getY() + endY - startY);
			thisMindNode.setLocation(node.getX(), node.getY());
			// thisMindNode.getParent().setVisible(false);
			// thisMindNode.getParent().setVisible(true);
			thisMindNode.getParent().repaint();

		} else {

			int x = -1;
			int y = -1;
			int w = -1;
			int h = -1;

			endX = e.getXOnScreen();
			endY = e.getYOnScreen();

			if (thisMindNode.getCursor().equals(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR))) {
				// mindnode x 위치는 - 그대로 변경, 사이즈는 +로
				// only X

				x = thisMindNode.getX() + endX - startX;
				w = thisMindNode.getWidth() - endX + startX;
				// System.out.println("getX = " + endX + " getY = " + endY);
				// System.out.println("getX = " + e.getPoint().getX() + " getY =
				// " + e.getPoint().getY());
				// System.out.println("x = " + x + " w = " + w);
				// System.out.println("Node BOund = " + node.getX() + " " +
				// node.getY() + " " + node.getW() + " " + node.getH());

				// thisMindNode.getParent().repaint();

			} else if (thisMindNode.getCursor().equals(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR))) {

				w = thisMindNode.getWidth() + endX - startX;

				// x 위치는
				// only X

			} else if (thisMindNode.getCursor().equals(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR))) {
				// only Y

				y = thisMindNode.getY() + endY - startY;
				h = thisMindNode.getHeight() - endY + startY;
				// System.out.println("getX = " + e.getX() + " getY = " +
				// e.getY());
				// resizeNode(thisMindNode,x,y,w,h);
				// thisMindNode.getParent().repaint();

			} else if (thisMindNode.getCursor().equals(Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR))) {
				// only Y
				h = thisMindNode.getHeight() + endY - startY;

			} else if (thisMindNode.getCursor().equals(Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR))) {
				y = thisMindNode.getY() + endY - startY;
				h = thisMindNode.getHeight() - endY + startY;
				x = thisMindNode.getX() + endX - startX;
				w = thisMindNode.getWidth() - endX + startX;
				// XY

			} else if (thisMindNode.getCursor().equals(Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR))) {
				// XY
				y = thisMindNode.getY() + endY - startY;
				h = thisMindNode.getHeight() - endY + startY;
				w = thisMindNode.getWidth() + endX - startX;

			} else if (thisMindNode.getCursor().equals(Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR))) {
				x = thisMindNode.getX() + endX - startX;
				w = thisMindNode.getWidth() - endX + startX;
				h = thisMindNode.getHeight() + endY - startY;
				// XY

			} else if (thisMindNode.getCursor().equals(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR))) {

				// XY
				h = thisMindNode.getHeight() + endY - startY;
				w = thisMindNode.getWidth() + endX - startX;

			}
			System.out.println(e.getXOnScreen());
			System.out.println(startX + " " + startY + " ");
			System.out.println(endX + " " + endY + " ");

			startX = endX;
			startY = endY;

			resizeNode(thisMindNode, x, y, w, h);

		}
	}

	private void resizeNode(MindNode mindNode, int x, int y, int w, int h) {
		if (x != -1)
			mindNode.getNode().setX(x);
		if (y != -1)
			mindNode.getNode().setY(y);
		if (w != -1)
			mindNode.getNode().setW(w);
		if (h != -1)
			mindNode.getNode().setH(h);
		Node node = mindNode.getNode();
		mindNode.setBounds(node.getX(), node.getY(), node.getW(), node.getH());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		int range = 3;

		MindNode thisMindNode = (MindNode) e.getSource();
		int width = thisMindNode.getWidth();
		int height = thisMindNode.getHeight();
		if (x <= range) {
			isResize = true;
			if (y <= range) {
				// WEST NORTH
				thisMindNode.setCursor(Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR));
			} else if (y >= height - range) {
				// WEST SOUTH
				thisMindNode.setCursor(Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR));
			} else {
				thisMindNode.setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
			}

		} else if (x >= width - range) {
			isResize = true;
			if (y <= range) {
				// EAST NORTH
				thisMindNode.setCursor(Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR));
			} else if (y >= height - range) {
				// EAST SOUTH
				thisMindNode.setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));
			} else {
				thisMindNode.setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
			}
		} else if (y <= range) {
			// ONLY SOUTH OR NORHT
			isResize = true;
			thisMindNode.setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));
		} else if (y >= height - range) {
			isResize = true;
			thisMindNode.setCursor(Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR));
		} else {
			isResize = false;
			thisMindNode.setCursor(Cursor.getDefaultCursor());
		}

	}

	public static MindNode getSelectedMindNode() {
		return selectedMindNode;
	}

	public static void setSelectedMindNode(MindNode selectedMindNode) {
		MindNodeMouseListener.selectedMindNode = selectedMindNode;
	}

}
