package Reservation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveFile {
	
	public SaveFile() {
		
	}
	
	public void saveToFile(String filename, String text, boolean append) throws IOException{
		File file1 = new File(filename);
		FileWriter fw = new FileWriter(file1,append);
		PrintWriter pw = new PrintWriter(fw);
		pw.println(text);
		pw.close();
	}
}
