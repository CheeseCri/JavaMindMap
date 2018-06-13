package Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JTextField;

import NodeTree.MindNode;
import NodeTree.Node;

public class MindNodeMouseListener implements MouseListener, MouseMotionListener{

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
		MindNode source = (MindNode)e.getSource();
		Node node = source.getNode();
//		System.out.println(source.getText());
		setSettingField(node.getName(), node.getX(), node.getY(), node.getW(), node.getH(), node.getColor());
		// TODO Auto-generated method stub
		
	}
	private void setSettingField(String name, int x, int y, int w, int h, String color) {
		settingItemNameEdit.setText(name);
		settingItemXEdit.setText(x+"");
		settingItemYEdit.setText(y+"");
		settingItemWEdit.setText(w+"");
		settingItemHEdit.setText(h+"");
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
		System.out.println("PRESS ? isDrage = " + this.isDraged);
		
		if(e.getX() == 0 || e.getY() == 0) {
			// TODO DRAG FOR RESIZE
			this.isResize = true;
		} else {
			this.startX = e.getX();
			this.startY = e.getY();
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		MindNode thisMindNode = (MindNode)e.getSource();
		Node node = thisMindNode.getNode();
		if(isDraged == true && isResize == false) {
			System.out.println("X = "+e.getXOnScreen() + " Y = " +e.getYOnScreen());
			endX = e.getX();
			endY = e.getY();
			node.setX(node.getX()+ endX - startX);
			node.setY(node.getY() + endY - startY);
			thisMindNode.setLocation(node.getX(), node.getY());
			thisMindNode.getParent().setVisible(false);
			thisMindNode.getParent().setVisible(true);
			this.isDraged = false;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		this.isDraged = true;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	
}
