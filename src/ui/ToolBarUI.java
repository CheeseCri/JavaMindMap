package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

import controller.FileController;
import controller.FileWrite;
import controller.JsonController;
import controller.JsonToTextController;

public class ToolBarUI {
	private JToolBar toolBar;
	private JTextArea textEditorPane;
	private FileController fileController;
	private FileWrite fileWrite;
	private JsonController jsonController;
	
	public ToolBarUI(JToolBar toolBar) {
		this.toolBar = toolBar;
		
		fileController = new FileController(this.textEditorPane);
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
		
		closeProgram.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				System.exit(0);
			}
		});
		
		
	}

	public JTextArea getTextEditorPane() {
		return textEditorPane;
	}

	public void setTextEditorPane(JTextArea textEditorPane) {
		this.textEditorPane = textEditorPane;
	}
	
	
	
}