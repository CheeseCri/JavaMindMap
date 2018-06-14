package ui;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class FileSaveUI extends JFileChooser {

	public FileSaveUI() {
		super();
		this.setCurrentDirectory(new File("."));
		this.setApproveButtonText("저장");
		this.setDialogTitle("저장");
	}
}
