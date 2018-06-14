package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Listener.AttributeButtenListener;
import Listener.TextAreaButtonListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;


import controller.FileController;
import controller.FileWrite;
import controller.JsonController;
import controller.JsonToTextController;

public class ToolBarUI {
	private JToolBar toolBar;
	private JTextArea textEditorPane;
	private JPanel mindMapPane;
	private FileController fileController;
	private FileWrite fileWrite;
	private JsonController jsonController;
	private AttributeButtenListener attributeButtenListener;
	private TextAreaButtonListener textAreabuttonListener;

	private JTextField n;
	private JTextField x;
	private JTextField y;
	private JTextField w;
	private JTextField h;
	private JTextField c;

	public ToolBarUI(JToolBar toolBar, JPanel mindMapPane, JTextField n, JTextField x, JTextField y, JTextField w, JTextField h, JTextField c
			, AttributeButtenListener attributeButtenListener, TextAreaButtonListener textAreaButtonListener) {
		this.toolBar = toolBar;
		this.mindMapPane = mindMapPane;
		this.n = n;
		this.y = y;
		this.x = x;
		this.w = w;
		this.h = h;
		this.c = c;
		this.attributeButtenListener = attributeButtenListener;
		this.textAreabuttonListener = textAreaButtonListener;
		fileController = new FileController(this.textEditorPane);
		fileController.getDrawController().setMindMapPane(mindMapPane);
		fileController.getDrawController().initEditorMemeber(n, x, y, w, h, c);
		fileWrite = new FileWrite();
		jsonController = new JsonController();

		JButton newFile = new JButton("새로 만들기");
		JButton openFile = new JButton("열기");
		JButton saveFile = new JButton("저장");
		JButton saveFileOtherName = new JButton("다른 이름으로 저장");
		JButton closeProgram = new JButton("닫기");

		JButton acceptText = new JButton("적용");
		JButton acceptSetting = new JButton("변경");

		toolBar.add(newFile);
		toolBar.add(openFile);
		toolBar.add(saveFile);
		toolBar.add(saveFileOtherName);
		toolBar.add(closeProgram);

		toolBar.add(acceptText);
		toolBar.add(acceptSetting);

		openFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fileController.setTextEditorPane(textEditorPane);
				fileController.makeUIOpenFile();
			}
		});

		saveFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// System.out.println(jsonController.setJson(MainUI.getTreeClass().getParent()));
				fileController.makeUISaveFile();
			}
		});

		saveFileOtherName.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fileController.makeUINewSaveFile();
			}
		});

		closeProgram.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				System.exit(0);
			}
		});

		newFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textEditorPane.setText("");
				mindMapPane.removeAll();
				mindMapPane.setVisible(false);
				mindMapPane.setVisible(true);
				MainUI.setTreeClass(null);

				n.setText("");
				x.setText("");
				y.setText("");
				w.setText("");
				h.setText("");
				c.setText("");
			}
		});
		
		acceptText.addActionListener(textAreaButtonListener);

		acceptSetting.addActionListener(attributeButtenListener);

	}

	public JTextArea getTextEditorPane() {
		return textEditorPane;
	}

	public void setTextEditorPane(JTextArea textEditorPane) {
		this.textEditorPane = textEditorPane;
	}

	public JPanel getMindMapPane() {
		return mindMapPane;
	}

	public void setMindMapPane(JPanel mindMapPane) {
		this.mindMapPane = mindMapPane;
	}

	public void initEditorMemeber(JTextField n, JTextField x, JTextField y, JTextField w, JTextField h, JTextField c) {
		this.n = n;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.c = c;
	}

}
