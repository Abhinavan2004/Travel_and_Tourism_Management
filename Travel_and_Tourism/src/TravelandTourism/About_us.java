package TravelandTourism;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class About_us extends JFrame implements ActionListener{

	JButton back;
	JTextArea area ;
	JLabel heading ;
	
	About_us(){
		setLayout(null);
		
        setBounds(450 , 180 , 790 ,525 );
		
		heading = new JLabel("ABOUT  US");
		heading.setFont(new Font("Tahoma" , Font.BOLD , 32));
		heading.setForeground(Color.RED);
	    heading.setBounds(300,0,600,50);
	    add(heading);
	    
	    String aa ="The objective of the Travel and Tourism Management System project is to develop a system that automates the processes and \nactivities of a travel agency. The purpose is to design a system using which one can perform all operations related to traveling.\r\n"
	    		+ "\r\n"
	    		+ "This application will help in accessing the information related to the travel to the particular destination with great ease. The users \ncan track the information related to their tours with great ease through this application. The travel agency information can also be obtained through this application.\r\n"
	    		+ "\r\n"
	    		+ "Advantages of Project:--\r\n"
	    		+ "\r\n"
	    		+ "Gives accurate information\r\n"
	    		+ "Simplifies the manual work\r\n"
	    		+ "It minimizes the documentation-related work\r\n"
	    		+ "Provides up-to-date information\r\n"
	    		+ "Friendly environment by providing warning messages\r\n"
	    		+ "Travelers' details can be provided\r\n"
	    		+ "Booking confirmation notifications";
	    
	    area = new JTextArea(aa, 20 ,40);
	    
	    area.setBounds(50,80 ,660 , 330);
        area.setFont(new Font("Tahoma", Font.BOLD, 14));
	    area.setEditable(false);
	    add(area);
	    
	    back = new JButton("BACK");
	    back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.addActionListener(this);
        back.setBounds(330	 , 420 , 100 ,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        
        add(back);
	    
	    setVisible(true);
	    

		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		About_us obj = new About_us();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == back) {
			setVisible(false);
			
		}
		
	}

}
