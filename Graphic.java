package tanwar;

import javax.swing.*;
import java.awt.event.*;
import java.util.regex.Pattern;

public class Graphic extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	JRadioButton r1, r2, r3, r4, r5, r6, r7;
	JButton b, button;
	JFrame frame;
	ButtonGroup group;
	JLabel nameL, balL, emailL, mobileL, or1, or2, l1, l2, l3;
	JTextField nameT, balT, emailT, mobileT, t;
	int whichAction = -1;
	
	public Graphic() {
		
	}
	public Graphic(String s) {
		
		super(s);
	}
	public void setComponents() {
		
		frame = this;
		
		r1 = new JRadioButton("To Open A New Account");
		r2 = new JRadioButton("To Withdraw Amount");
		r3 = new JRadioButton("To Deposit Amount");
		r4 = new JRadioButton("To check Account Details");
		
		nameL = new JLabel("Name");
		balL = new JLabel("Deposit Amount");
		emailL = new JLabel("Email                   (Optional)");
		mobileL = new JLabel("Mobile Number");
		or1 = new JLabel("OR");
		or2 = new JLabel("OR");
		
		nameT = new JTextField();
		balT = new JTextField();
		emailT = new JTextField();
		mobileT = new JTextField();
		
		b = new JButton("NEXT");
		button = new JButton("NEXT");
		
		b.addActionListener(this);
		button.addActionListener(new Action());
		
		group = new ButtonGroup();
		
		group.add(r1); group.add(r2); group.add(r3); group.add(r4);
		
		setLayout(null);
		
		r1.setBounds(50, 20, 200, 20);  r2.setBounds(300, 20, 200, 20);
		r3.setBounds(50, 60, 200, 20);  r4.setBounds(300, 60, 250, 20);
		
		b.setBounds(220, 110, 60, 40);
		
		add(b); 
		
		l1 = new JLabel();        l2 = new JLabel();        l3 = new JLabel();
		t = new JTextField();
		
		add(r1);  add(r2);  add(r3);  add(r4);	
		add(l1);  add(l2);  add(l3);  add(t);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(!r1.isSelected() && !r2.isSelected() && !r3.isSelected() && !r4.isSelected()) {
			
			return;
		}
		
		frame.add(button);
		button.setBounds(220, 410, 60, 40);
		frame.remove(t);
		l1.setText("");    l2.setText("");     l3.setText("");
		
		if(r1.isSelected()) {
			
			whichAction= 1;
			
			or1.setText("");  or2.setText("");
			nameT.setText(""); mobileT.setText(""); emailT.setText(""); balT.setText("");
			
			frame.add(nameL);    frame.add(nameT);
			frame.add(mobileL);  frame.add(mobileT);
			frame.add(emailL);   frame.add(emailT);
			frame.add(balL);     frame.add(balT);
			
			nameL.setBounds(50, 180, 200, 30);
			nameT.setBounds(250, 180, 250, 30);
			
			mobileL.setBounds(50, 235, 200, 30);
			mobileT.setBounds(250, 235, 250, 30);
			
			emailL.setBounds(50, 290, 200, 30);
			emailT.setBounds(250, 290, 250, 30);
			
			balL.setBounds(50, 345, 200, 30);
			balT.setBounds(250, 345, 250, 30);
			
			balL.setText("Deposit Amount");
			nameL.setText("Name");
			mobileL.setText("Mobile Number");
			emailL.setText("Email                   (Optional)");
		}
		else if(r2.isSelected()) {
			
			whichAction = 2;
			
			or1.setText("");  or2.setText("");
			balT.setText("");  nameT.setText("");

			mobileL.setText("");  frame.remove(mobileT);
			emailL.setText("");  frame.remove(emailT);
			
			frame.add(nameL); frame.add(nameT);
			frame.add(balL);   frame.add(balT);
			
			nameL.setBounds(50, 210, 200, 35);
			nameT.setBounds(250, 210, 250, 35);
			
			balL.setBounds(50, 310, 200, 35);
			balT.setBounds(250, 310, 250, 35);
			
			balL.setText("Withdraw Amount");
			nameL.setText("Account Number");
		}
		else if(r3.isSelected()) {
        	
			whichAction = 3;
			
			or1.setText("");  or2.setText("");
			balT.setText("");  nameT.setText("");

			mobileL.setText("");  frame.remove(mobileT);
			emailL.setText("");  frame.remove(emailT);
			
			frame.add(nameL); frame.add(nameT);
			frame.add(balL);   frame.add(balT);
			
			nameL.setBounds(50, 210, 200, 35);
			nameT.setBounds(250, 210, 250, 35);
			
			balL.setBounds(50, 310, 200, 35);
			balT.setBounds(250, 310, 250, 35);
			
			balL.setText("Deposit Amount");
			nameL.setText("Account Number");
        }
		else if(r4.isSelected()) {
        	
			whichAction = 4;
			
			balL.setText("");   frame.remove(balT);
			nameT.setText("");  mobileT.setText("");  emailT.setText("");
        	
			frame.add(nameL);       frame.add(nameT);
			frame.add(mobileL);     frame.add(mobileT);
			frame.add(emailL);      frame.add(emailT);
			frame.add(or1);         frame.add(or2);
			
			nameL.setBounds(50, 180, 200, 30);
			nameT.setBounds(250, 180, 250, 30);
			
			or1.setBounds(250, 225, 20, 20);
			
			mobileL.setBounds(50, 263, 200, 30);
			mobileT.setBounds(250, 263, 250, 30);
			
			or2.setBounds(250, 308, 20, 20);
			
			emailL.setBounds(50, 346, 200, 30);
			emailT.setBounds(250, 346, 250, 30);
			
			nameL.setText("Account Number");
			mobileL.setText("Mobile Number");
			emailL.setText("Email");
			or1.setText("OR");
			or2.setText("OR");
		}
	}
	
	class Action implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			frame.remove(t);
			l1.setText("");    l2.setText("");     l3.setText("");
			
			if(whichAction == 1) {
				
				String name = nameT.getText().trim(), email = emailT.getText().trim();
				double balance;
				long mobile = 0;
				if(name.length() == 0) {
					
					l1.setText("Enter Your name.");
					l1.setBounds(200, 500, 400, 20);
					return;
				}
				try {
					
				    balance = Double.valueOf(balT.getText().trim());
				}
				catch(NumberFormatException ex) {
					
					balance = 0;
				}
                try {
					
                	String s = mobileT.getText().trim();
				    if(s.length() != 10) throw new NumberFormatException();
				    if(!Pattern.matches("^[9876].*", s)) throw new NumberFormatException();
				    mobile = Long.valueOf(s);
				}
                catch(NumberFormatException ex) {
                	
                	l1.setText("Enter a valid mobile number.");
                	l1.setBounds(200, 500, 400, 20);
                	return;
                }
                if(email.length()<=1) email = "NA";
                if(!Pattern.matches(".+(@gmail.com)$", email) && !email.equals("NA")) {
                	
                	l1.setText("Enter a valid email id.");
                	l1.setBounds(200, 500, 400, 20);
                	return;
                }
				if(new NewCustomer().openAccount(balance, name, mobile, email, l1, l2, l3, t) == 1) {
					
					frame.add(t);
				}
			}
			else if(whichAction == 2 || whichAction == 3) {
				
				long accountNumber = 0;
				try {
					
				    accountNumber = Long.valueOf(nameT.getText());
				}
				catch(NumberFormatException ex) {
					
					l1.setText("Enter a valid Account Number.");
					l1.setBounds(200, 480, 400, 20);
				}
					
				new Customer(accountNumber, whichAction, l1, l2, l3, balT);
			}
			else if(whichAction == 4) {
				
				long accountNumber, mobile;
				String email = "";
				l1.setBounds(200, 500, 400, 20);
				
				if(nameT.getText().trim().length() != 0) {
					
					try {
						
					    accountNumber = Long.valueOf(nameT.getText().trim());
					    if(Customer.map().containsKey(accountNumber)) {
					    	
					    	new Customer(accountNumber, whichAction, l1, l2, l3, t);
					    	frame.add(t);
					    }
					    else {
					    	
					    	throw new NumberFormatException();
					    }
					}
					catch(NumberFormatException ex) {
						
						l1.setText("Enter a valid Account Number.");
					}
					return;
				}
                
                if(mobileT.getText().trim().length() != 0) {
                	
                	try {
    					
                    	String s = mobileT.getText().trim();
    				    if(s.length() != 10) throw new NumberFormatException();
    				    mobile = Long.valueOf(s);
                        if(Customer.getMobile().containsKey(mobile)) {
					    	
					    	new Customer(Customer.getMobile().get(mobile), whichAction, l1, l2, l3, t);
					    	frame.add(t);
					    }
					    else {
					    	
					    	throw new NumberFormatException();
					    }
    				}
                    catch(NumberFormatException ex) {
                    	
                    	l1.setText("Enter a valid Mobile Number.");
                    }
                	return;
                }
                
                if(emailT.getText().trim().length() != 0) {
                	
                	email = emailT.getText().trim();
                    if(Pattern.matches(".+(@gmail.com)$", email)) {
                    	
                    	if(Customer.getEmail().containsKey(email)) {
                    		
                    		new Customer(Customer.getEmail().get(email), whichAction, l1, l2, l3, t);
                    		frame.add(t);
                    	}
          
                    	else 
                    		l1.setText("Enter a valid Email id.");
                    }
                    else {
                    	
                    	l1.setText("Enter a valid email id.");
                    }
                    return;
                }
                l1.setText("Enter account Number or mobile Number or Email id.");
			}
		}
	}
}
