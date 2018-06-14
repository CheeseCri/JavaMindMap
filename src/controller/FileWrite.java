package controller;

import java.io.FileOutputStream;

public class FileWrite {

	public void writeJson(String filePath, String json) {
		FileOutputStream output;
		try {
			output = new FileOutputStream(filePath);
			output.write(json.getBytes());
			output.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
