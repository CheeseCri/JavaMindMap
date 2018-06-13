package controller;

import javax.swing.JPanel;
import javax.swing.JTextField;

import Listener.MindNodeMouseListener;
import NodeTree.MindNode;
import NodeTree.Node;
import ui.MainUI;

public class DrawController {

	private JPanel mindMapPane;
	private JTextField settingItemNameEdit;
	private JTextField settingItemXEdit;
	private JTextField settingItemYEdit;
	private JTextField settingItemWEdit;
	private JTextField settingItemHEdit;
	private JTextField settingItemCEdit;
	private MindNodeMouseListener mindNodeMouseListener;
	
	
	public DrawController() {

	}

	public DrawController(JPanel mindMapPane) {
		this.mindMapPane = mindMapPane;
	}

	public void initEditorMemeber(JTextField n, JTextField x, 
			JTextField y, JTextField w, JTextField h, JTextField c) {
		this.settingItemNameEdit = n;
		this.settingItemXEdit = x;
		this.settingItemYEdit = y;
		this.settingItemWEdit = w;
		this.settingItemHEdit = h;
		this.settingItemCEdit = c;
		mindNodeMouseListener = new MindNodeMouseListener(n, x, y, w, h, c);
	}

	public void drawMindMap() {
		Node rootNode = MainUI.getTreeClass().getRoot();
		MindNode mindRootNode = new MindNode(rootNode);
//		this.mindMapPane.add(mindRootNode);
		this.drawChildrenNode(mindRootNode);
		this.mindMapPane.setVisible(false);
		this.mindMapPane.setVisible(true);
	}
	
	private void drawChildrenNode(MindNode parent) {
		
		parent.addMouseListener(mindNodeMouseListener);
		this.mindMapPane.add(parent);
		if(parent.getNode().getChildren().size() == 0) return;
		for(Node child : parent.getNode().getChildren()) {
			MindNode childNode = new MindNode(child);
			drawChildrenNode(childNode);
			
		}
	}

}
