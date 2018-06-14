package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import NodeTree.TreeClass;
import controller.FileController;
import controller.FileWrite;
import controller.JsonController;
import controller.JsonToTextController;

public class MenuUI {
	private JMenuBar menuBar;
	private JTextArea textEditorPane;
	private JPanel settingPane;
	private JPanel mindMapPane;
	private FileController fileController;
	private FileWrite fileWrite;
	private JsonController jsonController;

	private JTextField n;
	private JTextField x;
	private JTextField y;
	private JTextField w;
	private JTextField h;
	private JTextField c;

	public MenuUI(JMenuBar menuBar, JPanel mindMapPane, JTextField n, JTextField x, JTextField y, JTextField w, JTextField h, JTextField c) {
		this.menuBar = menuBar;
		this.mindMapPane = mindMapPane;
		this.n = n;
		this.y = y;
		this.x = x;
		this.w = w;
		this.h = h;
		this.c = c;
		fileController = new FileController(this.textEditorPane);
		fileController.getDrawController().setMindMapPane(mindMapPane);
		fileController.getDrawController().initEditorMemeber(n, x, y, w, h, c);
		fileWrite = new FileWrite();
		jsonController = new JsonController();

		JMenu fileMenu = new JMenu("파일");
		JMenuItem newFile = new JMenuItem("새로 만들기");
		JMenuItem openFile = new JMenuItem("열기");
		JMenuItem saveFile = new JMenuItem("저장");
		JMenuItem saveFileOtherName = new JMenuItem("다른 이름으로 저장");
		JMenuItem closeProgram = new JMenuItem("닫기");

		fileMenu.add(newFile);
		fileMenu.add(openFile);
		fileMenu.add(saveFile);
		fileMenu.add(saveFileOtherName);
		fileMenu.add(closeProgram);

		JMenu mindMapMenu = new JMenu("마인드맵");
		JMenuItem acceptText = new JMenuItem("적용");
		JMenuItem acceptSetting = new JMenuItem("변경");

		mindMapMenu.add(acceptText);
		mindMapMenu.add(acceptSetting);

		this.menuBar.add(fileMenu);
		this.menuBar.add(mindMapMenu);

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
