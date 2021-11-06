package Reservation;

import Table.EditTable;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class RemoveReservationId implements RemoveReservation{
	
	EditTable editTable = new EditTable();
	
	public RemoveReservationId() {
		
	}
	
	public void removeReservation(String filepath,String removeTerm) {
		String tempFile = "temp.txt";
		File oldFile = new File(filepath);
		File newFile = new File(tempFile);
		
		String currentline;
		String data[];
		
		try {
			FileWriter fw = new FileWriter(tempFile,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			FileReader fr = new FileReader(filepath);
			BufferedReader br = new BufferedReader(fr);
			
			while((currentline = br.readLine())!= null) {
				data = currentline.split("\\|");
				if(!(data[0].equalsIgnoreCase(removeTerm))) {
					pw.println(currentline);
				}else if (data[0].equalsIgnoreCase(removeTerm)){
					editTable.editTableDetail("tables.txt",Integer.parseInt(data[1]),"VACANT");
				}
			}
			pw.flush();
			pw.close();
			fr.close();
			br.close();
			bw.close();
			fw.close();
			
			oldFile.delete();
			File dump = new File(filepath);
			newFile.renameTo(dump);
		}
		catch(Exception e) {}
	}
}
