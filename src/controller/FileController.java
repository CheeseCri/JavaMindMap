package controller;

import java.io.File;

import ui.FileOpenUI;

public class FileController {
	private File file;
	private FileOpenUI fileOpenUI;
	
	public FileController() {
		this.fileOpenUI = new FileOpenUI();
	}
	
	public void makeUIOpenFile() {
		int openRes = fileOpenUI.showOpenDialog(null);
		fileOpen(openRes);
	}
	
	private void fileOpen(int openRes) {
		this.file = fileOpenUI.getSelectedFile();
		if(openRes == FileOpenUI.APPROVE_OPTION) 
			System.out.println(file.getName());
	}
	
	
}
