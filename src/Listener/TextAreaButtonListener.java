package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JTextArea;

import NodeTree.TreeClass;
import controller.NodeMaker;
import ui.MainUI;

public class TextAreaButtonListener implements ActionListener{

	private JTextArea textArea;
	
	public TextAreaButtonListener() {
		
	}
	public TextAreaButtonListener(JTextArea textArea) {
		
		this.textArea = textArea;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
//		System.out.println(textArea.getText());
		
		NodeMaker maker = new NodeMaker(textArea.getText());
		maker.makeTree();
		
		MainUI.getTreeClass().print(0);
	}
		

	
	
}
