package Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;

import NodeTree.MindNode;
import NodeTree.Node;

public class MindNodeMouseListener implements MouseListener{

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
		node.setColor("FFDFDD");
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
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
