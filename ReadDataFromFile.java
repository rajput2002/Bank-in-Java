package tanwar;

import java.io.*;
import java.util.*;

class ReadDataFromFile {
	
	private ReadDataFromFile(){}
	
	private static HashMap<String, Long> emails = null;
	private static HashMap<Long, Long> mobile = null;
	private static HashMap<Long, Account> map = null;
	
	protected static HashMap<String, Long> getEmails(){
		
		if(emails == null) {
			
			try {
				
				readDetailFromFile();
			}
			catch(IOException io) {
				
			}
		}
		return emails;
	}
	
    protected static HashMap<Long, Long> getMobile(){
		
        if(mobile == null) {
			
			 try {
				
				 readDetailFromFile();
			 }
			 catch(IOException io) {
				
		     }
		}
		return mobile;
	}
    
    protected static HashMap<Long, Account> getAccount(){
    	
        if(map == null) {
			
			try {
				
				readDetailFromFile();
			}
			catch(IOException io) {
				
			}
		}
    	return map;
    }
	
	protected static void readDetailFromFile() throws IOException{
		
		File file = new File("./bankdetails.txt");
		
		if(!file.exists()) {
			
			file.createNewFile();
		}
		long length = file.length();
		
		map = new HashMap<Long, Account>();
		emails = new HashMap<String, Long>();
		mobile = new HashMap<Long, Long>();
		
		if(length <= 1) {
			
			return;
		}
		
		FileReader fr = new FileReader("./bankdetails.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String s = new String();
		
		while((s = br.readLine()) != null) {
			
			long accountNumber, mobileNumber;
			double balance;
			String name = new String(), email;
			
			String[] str = s.split("[ ]+");
			
			accountNumber = Long.valueOf(str[0]);
			mobileNumber = Long.valueOf(str[1]);
			email = str[2];
			balance = Double.valueOf(str[3]);
			name = str[4];
			
			Account account = new Account(balance, name, mobileNumber, email);
			
			map.put(accountNumber, account);
			if(!email.equals("NA")) emails.put(email, accountNumber);
			mobile.put(mobileNumber, accountNumber);
		}
		
		br.close();
	}
}




