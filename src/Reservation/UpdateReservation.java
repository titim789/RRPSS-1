package Reservation;

import Table.EditTable;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class UpdateReservation {
	
	private CheckReservation checkReserve = new CheckReservation();
	private EditTable editTable = new EditTable();
	
	public UpdateReservation(){
		
	}
	
	public void updateReservation(String filepath) {

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Customer Id to Check : ");
		String editTerm = scan.next();

		checkReserve.checkReservation(Integer.parseInt(editTerm));

		int choice;
		String table_id = ""; String cus_id = "";String date = "";String nopax = ""; String cname = "";String contactno = "";
		do{
			System.out.println("\nSelect Parameter you want to change?");
			System.out.println("1 : Change Table ID");
			System.out.println("2 : Change Customer ID");
			System.out.println("3 : Change Date Time");
			System.out.println("4 : Change Number of People");
			System.out.println("5 : Change Customer Name");
			System.out.println("6 : Change Contact Number");
			System.out.println("7 : Stop Changing");
			System.out.print("Enter Choice : ");
			choice = scan.nextInt();
			switch(choice){
				case 1:
					System.out.print("Enter new Table ID : ");
					table_id = scan.next();
					break;
				case 2:
					System.out.print("Enter new Customer ID : ");
					cus_id = scan.next();
					break;
				case 3:
					System.out.print("Enter new Date Time in (dd/MM/yyyy,HH:mm) format: ");
					date = scan.next();
					break;
				case 4:
					System.out.print("Enter new Number of People ");
					nopax = scan.next();
					break;
				case 5:
					System.out.print("Enter new Customer Name : ");
					cname = scan.next();
					break;
				case 6:
					System.out.print("Enter new Contact Number : ");
					contactno = scan.next();
					break;
			}
		}while(choice != 7);

		String tempFile = "tempupdate.txt";
		File oldFile = new File(filepath);
		File newFile = new File(tempFile);
		String rid = "";String tid = ""; String cid = "";String dt = "";String pax = ""; String name = "";String contact = "";

		try {
			FileWriter fw = new FileWriter(tempFile,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			Scanner x = new Scanner(new File(filepath));

			while(x.hasNextLine()){
				String line = x.nextLine();
				String[] items = line.split("\\|");

				rid = items[0];
				tid = items[1];
				cid = items[2];
				dt = items[3];
				pax = items[4];
				name = items[5];
				contact = items[6];
				if(cid.equals(editTerm)){

					if(table_id == "") table_id = tid;
					if(cus_id == "") cus_id = cid;
					if(date == "") date = dt;
					if(nopax == "") nopax = pax;
					if(cname == "") cname = name;
					if(contactno == "") contactno = contact;

					if(table_id != tid){ // change in table
						editTable.editTableDetail("tables.txt",Integer.parseInt(tid),"VACANT");
						editTable.editTableDetail("tables.txt",Integer.parseInt(table_id),"RESERVED");
					}

					pw.println(rid + "|" + table_id + "|" + cus_id + "|" + date + "|" + nopax + "|" + cname + "|" + contactno);
				}
				else{
					pw.println(rid + "|" + tid + "|" + cid + "|" + dt + "|" + pax + "|" + name + "|" + contact);
				}
			}
			x.close();
			pw.flush();
			pw.close();	
			oldFile.delete();
			File dump = new File(filepath);
			newFile.renameTo(dump);
			scan.close();
		}
		catch(Exception e) {}
	}

}
