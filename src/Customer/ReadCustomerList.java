package Customer;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.lang.String;
import java.io.FileReader;
import java.io.IOException;


public class ReadCustomerList {
	private ArrayList<Customer> ListOfCustomer = new ArrayList<Customer>();
	
	public ReadCustomerList() {}
	
	public int readLastCustomerId(String fileName){
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			//to store a line
			String line = "";
			String line2 = "";
			
			while((line = br.readLine()) != null) {
				//// test printing the file
				// System.out.println(line);
				String[] values = line.split(",");	
//				System.out.println(line);
				line2 = line;
			}
			
			String[] lastrow = line2.split(",");
			int a = Integer.parseInt(lastrow[0]);
//			System.out.println("last customer id");
//			System.out.println(a);
			return a;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// catch IO exception for br.readline()
			e.printStackTrace();
		}
		return 0;
		
	}
	
	
	public ArrayList<Customer> readCustomerFromFile(String fileName){
		ListOfCustomer.clear();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			//to store a line
			String line = "";
			
			// to consume the header row of csv
			String headerLine = "";
			headerLine = br.readLine();
			
			// keeps instanciating staff object until no more rows
			while((line = br.readLine()) != null) {			
				// split a line of string into an array
				// [0] is id, [1] is name etc...
				String[] values = line.split(",");
				
				// takes the corresponding array[0], fit into staff object
//				Staff staff = new Staff();
				Customer customer = new Customer();
				customer.setCustomer_id(Integer.parseInt(values[0]));
				customer.setName(values[1]);
				customer.setPhone(values[2]);
				
				if(values[3] == "y") {
					customer.setMember(true);
				}else {
					customer.setMember(false);
				}
				
				ListOfCustomer.add(customer);
			}
			
		} 
		// catch blocks for reading csv or if not will throw error
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// catch IO exception for br.readline()
			e.printStackTrace();
		}
		
		return ListOfCustomer;
	}

	
	
}
