package controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWrite {
	
	public void writeJson(String filePath, String json){
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
