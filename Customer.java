package tanwar;

import java.util.*;
import javax.swing.*;

public class Customer {
	
	private long accountNumber;
	private Account account;
	private static HashMap<Long, Account> map = null;
	private static HashMap<String, Long> emails = null;
	private static HashMap<Long, Long> mobile = null;
	int n;
	
	protected Customer(long accountNumber, int n, JLabel l1, JLabel l2, JLabel l3, JTextField t) {
		
		this.accountNumber = accountNumber;
		this.n = n;
		
		if(map == null || emails == null || mobile == null) {
			
			readData();
		}
		if(!accountExist(accountNumber)) {
			
			l1.setText("Your Account Number is Wrong.");
			l1.setBounds(200, 480, 400, 20);
			l2.setText("");
			return;
		}
		getAccountDetails(accountNumber);
		action(l1, l2, l3, t);
	}
	
	protected static boolean accountExist(long accountNumber) {
		
        if(map == null) {
			
			readData();
		}
		return map.containsKey(accountNumber);
	}
	
	protected static HashMap<Long, Account> map() {
		
        if(map == null) {
			
			readData();
		}
		return map;
	}
	
    protected static HashMap<Long, Long> getMobile() {
		
        if(map == null) {
			
			readData();
		}
		return mobile;
	}

    protected static HashMap<String, Long> getEmail() {
	
        if(map == null) {
		
		    readData();
	    }
	    return emails;
    }
	
	private static void readData() {
		
		map = ReadDataFromFile.getAccount();
		mobile = ReadDataFromFile.getMobile();
		emails = ReadDataFromFile.getEmails();
	}
	
	private void getAccountDetails(long accountNumber) {
		
		this.account = map.get(accountNumber);
	}
	
	private void action(JLabel l1, JLabel l2, JLabel l3, JTextField t) {
		
		switch(n) {
		  
		     case 2 : double amount = 0;
		              try{
		            	  
		            	  amount = Double.valueOf(t.getText());
		              }
		              catch(NumberFormatException ex) {
		            	  
		            	  amount = 0;
		              }
		              
		    	      double balance = account.withdrawl(amount, l1, l2);
		    	      
		    	      map.replace(this.accountNumber, new Account(balance, account.getName(), 
		    	    		                  account.getMobileNumber(), account.getEmail()));
		    	      break;
		    	      
		     case 3 : double amt;
                      try{
           	  
           	               amt = Double.valueOf(t.getText());
                      }
                      catch(NumberFormatException ex) {
           	  
           	               amt = 0;
                      }
   	                  double balance1 = account.deposit(amt, l1, l2);
   	                  map.replace(this.accountNumber, new Account(balance1, account.getName(),
   	                		                   account.getMobileNumber(), account.getEmail()));
   	                  break;
   	                  
		     case 4 : account.bankDetails(l1, l2, l3, t, accountNumber);
		}
	}
}



