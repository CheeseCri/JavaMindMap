package ui;

import java.io.File;

import javax.swing.JFileChooser;

public class FileNewSaveUI extends JFileChooser {

	public FileNewSaveUI() {
		super();
		this.setCurrentDirectory(new File("."));
		this.setApproveButtonText("저장");
		this.setDialogTitle("다른 이름으로 저장");
	}
}
