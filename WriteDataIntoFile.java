package tanwar;

import java.io.*;
import java.util.*;

public class WriteDataIntoFile {

	static WriteDataIntoFile w = null;
	
	private WriteDataIntoFile() {
		
	}
	
	protected static WriteDataIntoFile getInstance() {
		
		if(w == null) {
			
			w = new WriteDataIntoFile();
		}
		return w;
	}
	
	protected void writeData() throws IOException{
		
		FileWriter fw = new FileWriter("./bankdetails.txt");
		BufferedWriter bf = new BufferedWriter(fw);
		
		HashMap<Long, Account> map = Customer.map();
		
		for(long accountNumber : map.keySet()) {
			
			Account account = map.get(accountNumber);
			
			double balance = account.getBalance();
			String name = account.getName();
			long mobileNumber = account.getMobileNumber();
			String email = account.getEmail();
			
			String s = ""+accountNumber+" "+mobileNumber+" "+email+" "+balance+" "+name;
			
			bf.write(s);
			bf.newLine();
		}
		bf.close();
	}
}





