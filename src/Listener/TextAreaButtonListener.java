package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

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
	}
	
	
}
