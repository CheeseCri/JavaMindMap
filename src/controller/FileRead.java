package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileRead {
	
	public String readJson(String filePath){
		String json = "";

		try {
			File file = new File(filePath);
			Scanner scan = new Scanner(file);
			json = json + scan.nextLine();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return json;
		
	}
}
