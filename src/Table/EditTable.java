package Table;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class EditTable {
	
	public EditTable() {
		
	}
	
	public void editTableDetail(String filepath,int num, String newstatus){
		String tempFile = "temptable.txt";
		File oldFile = new File(filepath);
		File newFile = new File(tempFile);
		String tid = ""; String pax = ""; String state = "";
		String editTerm = Integer.toString(num);

		try {
			FileWriter fw = new FileWriter(tempFile,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			Scanner sc = new Scanner(new File(filepath));

			while(sc.hasNextLine()){
				String line = sc.nextLine();
				String[] items = line.split("\\|");

				tid = items[0];
				pax = items[1];
				state = items[2];
				if(tid.equals(editTerm)){
					pw.println(tid + "|" + pax + "|" + newstatus);
				}
				else{
					pw.println(tid + "|" + pax + "|" + state);
				}
			}
			sc.close();
			pw.flush();
			pw.close();	
			oldFile.delete();
			File dump = new File(filepath);
			newFile.renameTo(dump);
		}
		catch(Exception e) {}
	}
}
