package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.DrawController;
import controller.NodeMaker;
import ui.MainUI;

public class TextAreaButtonListener implements ActionListener{
	private JTextArea textArea;
	private JPanel mindMapPane;
	private JTextField n;
	private JTextField x;
	private JTextField y;
	private JTextField w;
	private JTextField h;
	private JTextField c;
	
	public TextAreaButtonListener() {
		
	}
	public TextAreaButtonListener(JTextArea textArea, JPanel mindMapPane) {
		
		this.textArea = textArea;
		this.mindMapPane = mindMapPane;
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
	public void actionPerformed(ActionEvent arg0) {
//		System.out.println(textArea.getText());
		mindMapPane.removeAll();
		mindMapPane.repaint();
		NodeMaker maker = new NodeMaker(textArea.getText());
		maker.makeTree();
		
		MainUI.getTreeClass().print(0);
		DrawController drawer = new DrawController(mindMapPane);
		drawer.initEditorMemeber(n, x, y, w, h, c);
		drawer.drawMindMap();
	}
		

	
	
}
