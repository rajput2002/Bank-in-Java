package tanwar;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) {
		
		Graphic g = new Graphic("Bank in Java");
		g.setComponents();
		g.setSize(600, 700);
		g.setVisible(true);
		g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		g.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	
                WriteDataIntoFile w = WriteDataIntoFile.getInstance();
                try {
                	
        		    w.writeData();
                }
                catch(IOException ex) {
                }
            }
        });
	}

}
