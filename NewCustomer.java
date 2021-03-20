package tanwar;

import java.util.*;
import javax.swing.*;

public class NewCustomer {
	
	protected NewCustomer() {
	}
	
	protected int openAccount(double balance, String name, long mobile, String email,
                                      JLabel l1, JLabel l2, JLabel l3, JTextField t) {
		
		HashMap<Long, Account> map = Customer.map();
		HashMap<String, Long> emails = Customer.getEmail();
		HashMap<Long, Long> mobiles = Customer.getMobile();
		
		Account account = new Account(balance, name, mobile, email);
		
		l1.setBounds(200, 480, 450, 30);
		if(emails.containsKey(email)) {
			
			if(mobiles.containsKey(mobile)) {
				
				l1.setText("This Email id and Mobile Number already exist.");
				return -1;
			}
			l1.setText("This Email already exist.");
			return -1;
		}
		if(mobiles.containsKey(mobile)) {
			
			l1.setText("This Mobile Number already exist.");
			return -1;
		}
		long accountNumber = generateAccountNumber();
		
		map.put(accountNumber, account);
		if(!email.equals("NA")) emails.put(email, accountNumber);
		mobiles.put(mobile, accountNumber);
		
		t.setText(String.valueOf(accountNumber));
		t.setBounds((int)(account.getName().length()*7)+230, 480, 135, 30);
		
		l1.setText("\""+account.getName()+"\", Your Account Number is ");
		l2.setText("and Your Bank balance is \""+account.getBalance()+"\" Rs. and Your Mobile Number");
		if(email.equals("NA")) l3.setText("is \""+account.getMobileNumber()+"\".");
		else l3.setText("is \""+account.getMobileNumber()+"\" and Your email id is \""+account.getEmail()+"\".");
		l1.setBounds(50, 480, 450, 30);
		l2.setBounds(50, 520, 550, 30);
		l3.setBounds(50, 560, 550, 30);
		return 1;
	}
	
	private long generateAccountNumber() {
		
		Random random = new Random();
		long accountNumber;
		
		while(true) {
			
			accountNumber = random.nextLong();

			if(accountNumber < 0){

				continue;
			}
			
			long n = accountNumber;
			int i;
			
			for(i=0; n!=0; i++) {
				
				n = n/10;
			}
			
			int j = i - 15;
			
			if(j < -5) {
				
				continue;
			}
			
			int k = 1;
			
			for(int m=0; m<j; m++) {
				
				k = k*10;
			}
			
			accountNumber = accountNumber/k;
			
			if(!Customer.accountExist(accountNumber)) {
				
				return accountNumber;
			}
		}
	}
}



