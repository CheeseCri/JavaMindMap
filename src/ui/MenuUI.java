package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import NodeTree.TreeClass;
import controller.FileController;
import controller.FileWrite;
import controller.JsonController;

public class MenuUI {
	private JMenuBar menuBar;
	private JTextArea textEditorPane;
	private JPanel settingPane;
	private FileController fileController;
	private FileWrite fileWrite;
	private JsonController jsonController;
	
	public MenuUI(JMenuBar menuBar) {
		this.menuBar = menuBar;
		
		fileController = new FileController();
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
				fileController.makeUIOpenFile();
				
			}
		});
		
		saveFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(jsonController.setJson(MainUI.getTreeClass().getParent()));
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
		
	}
}
