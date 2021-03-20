package tanwar;

import javax.swing.*;

class Account {
	
	private double balance;
	private String name, email = "NA";
	private long mobileNumber;
	
    protected Account(double balance, String name, long mobileNumber) {
		
		this.balance = balance;
		this.name = name;
		this.mobileNumber = mobileNumber;
	}
    
    protected Account(double balance, String name, long mobileNumber, String email) {
		
		this.balance = balance;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}
	
	protected double withdrawl(double amount, JLabel l1, JLabel l2) {
		
		if(this.balance < amount) {
			
			l1.setText("\""+name+"\", Transaction Unsuccessful because Your Bank Balance");
			l2.setText("(\"+ this.balance +\" Rs.)\" is less than Your Withdrawl Amount ("+amount+" Rs.)");
			l1.setBounds(50, 480, 500, 20);
			l2.setBounds(50, 520, 500, 20);
			return this.balance;
		}
		
		this.balance = this.balance - amount;
		l1.setText("\""+name+"\", Transaction Successful and Now");
		l2.setText("Your Bank Balance is \""+this.balance+"\" Rs.");
		l1.setBounds(100, 480, 500, 20);
		l2.setBounds(100, 520, 500, 20);
		
		return this.balance; 
	}
	
	protected double deposit(double amount, JLabel l1, JLabel l2) {
		
		this.balance = this.balance + amount;
		l1.setText("\""+name+"\", Transaction Successful and Now Your");
		l2.setText("Bank Balance is \""+this.balance+"\" Rs.");
		l1.setBounds(100, 480, 500, 20);
		l2.setBounds(100, 520, 500, 20);
		return this.balance;
	}
	
	protected void bankDetails(JLabel l1, JLabel l2, JLabel l3, JTextField t, long accountNumber) {
		
		l1.setText("Your name is \""+this.name+"\" and Your Current Bank Balance is \""+this.balance+"\"Rs.");
		if(email.equals("NA")) l2.setText("Your Mobile Number is \""+this.mobileNumber+"\".");
		else l2.setText("Your Mobile Number is \""+this.mobileNumber+"\" and Your Email id is \""+this.email+"\".");
		l3.setText("Your Account Number is ");
		t.setText(""+accountNumber);
		
		l1.setBounds(50, 480, 550, 30);
		l2.setBounds(50, 520, 550, 30);
		l3.setBounds(50, 560, 550, 30);
		t.setBounds(207, 560, 135, 30);
	}
	
	protected String getName() {
		
		return this.name;
	}
	
	protected double getBalance() {
		
		return this.balance;
	}
	
	protected long getMobileNumber() {
		
		return this.mobileNumber;
	}
	
	protected String getEmail() {
		
		return this.email;
	}
}


