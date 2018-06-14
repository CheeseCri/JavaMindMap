package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import NodeTree.Node;

public class AttributeButtenListener implements ActionListener {
	
	private JTextField n;
	private JTextField x;
	private JTextField y;
	private JTextField w;
	private JTextField h;
	private JTextField c;
	
	public AttributeButtenListener() {
		// TODO Auto-generated constructor stub
	}
	
	public void initEditorMemeber(JTextField n, JTextField x, 
			JTextField y, JTextField w, JTextField h, JTextField c) {
		this.n = n;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.c = c;
	}
	
	
	@Override
	//버튼 눌렀을 때 실행 될 내용
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Node selectedNode = MindNodeMouseListener.getSelectedMindNode().getNode();
		System.out.println(n.getText());
		
		selectedNode.setX(Integer.parseInt(x.getText()));
		System.out.println(selectedNode.getX());
		
		System.out.println(y.getText());
		selectedNode.setY(Integer.parseInt(y.getText()));
		System.out.println(selectedNode.getY());
		
		System.out.println(w.getText());
		selectedNode.setW(Integer.parseInt(w.getText()));
		System.out.println(selectedNode.getW());
		
		System.out.println(h.getText());
		selectedNode.setH(Integer.parseInt(h.getText()));
		System.out.println(selectedNode.getH());
		
		System.out.println(c.getText());
		selectedNode.setColor(c.getText());
		System.out.println(selectedNode.getColor());
		
		MindNodeMouseListener.getSelectedMindNode().setBounds(
				Integer.parseInt(x.getText()),Integer.parseInt(y.getText()), Integer.parseInt(w.getText()),Integer.parseInt(h.getText()));
		MindNodeMouseListener.getSelectedMindNode().getParent().repaint();
	}

}
