package controller;

import java.io.File;

import NodeTree.TreeClass;
import ui.FileNewSaveUI;
import ui.FileOpenUI;
import ui.FileSaveUI;
import ui.MainUI;

public class FileController {
	private File file;
	private static String filePath = "";
	private FileOpenUI fileOpenUI;
	private FileSaveUI fileSaveUI;
	private FileNewSaveUI fileNewSaveUI;
	private FileWrite fileWrite;
	private FileRead fileRead;
	private JsonController jsonController;
	private String json;

	public FileController() {
		this.fileOpenUI = new FileOpenUI();
		this.fileSaveUI = new FileSaveUI();
		this.fileNewSaveUI = new FileNewSaveUI();
		this.fileWrite = new FileWrite();
		this.fileRead = new FileRead();
		this.jsonController = new JsonController();
		
	}

	public void makeUIOpenFile() {
		int openRes = fileOpenUI.showOpenDialog(null);
		fileOpen(openRes);
	}

	private void fileOpen(int openRes) {
		this.file = fileOpenUI.getSelectedFile();
		
		if (openRes == FileOpenUI.APPROVE_OPTION){
			System.out.println(file.getAbsolutePath());
			//읽어온 파일 READ
			json = fileRead.readJson(file.getAbsolutePath());
			//MainUI의 트리 새로 생성
			MainUI.setTreeClass(new TreeClass(jsonController.getJson(json)));
			//System.out.println(jsonController.getJson(json));
		}
	}

	public void makeUISaveFile() {
		if (filePath.equals("")) {
			int saveRes = fileSaveUI.showSaveDialog(null);
			fileSave(saveRes);
		} else
			fileWrite.writeJson(filePath, jsonController.setJson(MainUI.getTreeClass().getRoot()));
	}
	

	// filePath가 ""일 경우에는 fileSaveUI를 불러온다.
	// 그렇지 않은 경우, 저장을 수행한다.
	private void fileSave(int saveRes) {
		this.file = fileSaveUI.getSelectedFile();
		if (saveRes == FileSaveUI.APPROVE_OPTION) {
			System.out.println("저장 경로 : " + fileSaveUI.getSelectedFile().toString());
			this.filePath = fileSaveUI.getSelectedFile().toString();
			// fileWrite기능 수행
			fileWrite.writeJson(filePath, jsonController.setJson(MainUI.getTreeClass().getRoot()));
		}
	}
	
	public void makeUINewSaveFile() {
		int newSaveRes = fileNewSaveUI.showSaveDialog(null);
		fileNewSave(newSaveRes);
	}
	
	private void fileNewSave(int newSaveRes){
		this.file = fileNewSaveUI.getSelectedFile();
		if (newSaveRes == FileSaveUI.APPROVE_OPTION) {
			System.out.println("새 저장 경로 : " + fileNewSaveUI.getSelectedFile().toString());
			this.filePath = fileNewSaveUI.getSelectedFile().toString();
			// fileWrite기능 수행
			fileWrite.writeJson(filePath, jsonController.setJson(MainUI.getTreeClass().getRoot()));
		}
	}

	public static String getFilePath() {
		return filePath;
	}

}
