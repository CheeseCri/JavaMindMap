package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

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
		System.out.println(n.getText());
		System.out.println(x.getText());
		System.out.println(y.getText());
		System.out.println(w.getText());
		System.out.println(h.getText());
		System.out.println(c.getText());
	}

}
