package ui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuUI {
	private JMenuBar menuBar;
	
	public MenuUI(JMenuBar menuBar) {
		this.menuBar = menuBar;
		
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
		
	}
}
