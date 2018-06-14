package ui;

import java.io.File;

import javax.swing.JFileChooser;

public class FileOpenUI extends JFileChooser {

	public FileOpenUI() {
		super();
		this.setCurrentDirectory(new File("."));
		this.setApproveButtonText("열기");
		this.setDialogTitle("열기");
		// this.setFileFilter(new FileFilter() {
		// public boolean accept(File f) {
		// String fileName = f.getName();
		// if(fileName.indexOf(".java")!=-1)
		// return true;
		// else if(f.isDirectory())
		// return true;
		// return false;
		// }
		// public String getDescription() {
		// return ".java";
		// }
		// });
	}
}
