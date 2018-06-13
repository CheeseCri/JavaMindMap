package ui;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class FileNewSaveUI extends JFileChooser{

		public FileNewSaveUI() {
			super();
			this.setApproveButtonText("저장");
			this.setDialogTitle("다른 이름으로 저장");
		}
}
