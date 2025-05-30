package TravelandTourism;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Check_Package extends JFrame implements ActionListener {
	
	JTabbedPane tab1;
	JPanel p1 ,p2, p3;
	JLabel heading , heading2 , heading3 ,heading4 , heading5 , heading6 , heading7 , heading8 ,heading9 , heading10 , heading11;
	JButton back , book;
	
	Check_Package(){
		
		 String[] package_1 = new String[]{"package1.jpg","BRONZE PACKAGE","6 days and 7 Nights", "Airport Assistance at Aiport", "Half Day City Tour", "Welcome drinks on Arrival", "Daily Buffet", "Full Day 3 Island Cruise", "English Speaking Guide", "BOOK NOW", "Summer Special", "Rs 12000 only"};
	      String[] package_2 = new String[]{"package2.jpg","SILVER PACKAGE","4 days and 3 Nights", "Toll Free and Entrance Free Tickets", "Meet and Greet at Aiport", "Welcome drinks on Arrival", "Night Safari", "Full Day 3 Island Cruise", "Cruise with Dinner", "BOOK NOW", "Winter Special", "Rs 25000 only"};
	      String[] package_3 = new String[]{"package3.jpg","GOLD PACKAGE","6 days and 5 Nights", "Return Airfare", "Free Clubbing, Horse Riding & more", "Welcome drinks on Arrival", "Daily Buffet", "Stay in 5 Star Hotel", "BBQ Dinner", "BOOK NOW", "Winter Special", "Rs 32000 only"};
		tab1 = new JTabbedPane();
		
		p1 = createPackage(package_1);
		tab1.addTab("Package 1", null , p1);
		p2 = createPackage(package_2);
		tab1.addTab("Package 2" , null , p2);
		p3 = createPackage(package_3);
		tab1.addTab("Package 3", null, p3);
		
		add(tab1);
		
        setBounds(250 , 150 , 1170 ,625 );
        setTitle("Check_Package");
        setVisible(true);
	}
	
	
	


	public JPanel createPackage(String [] packages) {
		 p1 = new JPanel();
        p1.setLayout(null);
       
		
		heading = new JLabel(packages[1]);
		heading.setBounds(40,50,400,40);
		heading.setFont(new Font("Georgia" , Font.BOLD , 36));
		heading.setForeground(new Color(230,189,55));
		p1.add(heading);
		
		
		heading2 = new JLabel(packages[2]);
		heading2.setBounds(80,120,300,40);
		heading2.setFont(new Font("Tahoma" , Font.BOLD , 24));
		heading2.setForeground(Color.red);
		p1.add(heading2);
		
		
		heading3 = new JLabel(packages[3]);
		heading3.setBounds(80,170,500,40);
		heading3.setFont(new Font("Tahoma" , Font.BOLD , 24));
		heading3.setForeground(Color.blue);
		p1.add(heading3);
		
		heading4 = new JLabel(packages[4]);
		heading4.setBounds(80,220,500,40);
		heading4.setFont(new Font("Tahoma" , Font.BOLD , 24));
		heading4.setForeground(Color.red);
		p1.add(heading4);
		
		heading5 = new JLabel(packages[5]);
		heading5.setBounds(80,270,400,40);
		heading5.setFont(new Font("Tahoma" , Font.BOLD , 24));
		heading5.setForeground(Color.blue);
		p1.add(heading5);
		
		
		heading6 = new JLabel(packages[6]);
		heading6.setBounds(80,320,300,40);
		heading6.setFont(new Font("Tahoma" , Font.BOLD , 24));
		heading6.setForeground(Color.red);
		p1.add(heading6);
		
		heading7 = new JLabel(packages[7]);
		heading7.setBounds(80,370,300,40);
		heading7.setFont(new Font("Tahoma" , Font.BOLD , 24));
		heading7.setForeground(Color.blue);
		p1.add(heading7);
		
		heading8 = new JLabel(packages[8]);
		heading8.setBounds(80,420,300,40);
		heading8.setFont(new Font("Tahoma" , Font.BOLD , 24));
		heading8.setForeground(Color.red);
		p1.add(heading8);
		
		
		book = new JButton("BOOK PACKAGE");
		book.setBounds(150,490,300,40);
		book.setFont(new Font("Tahoma" , Font.BOLD , 28));
		book.setForeground(Color.black);
		book.setContentAreaFilled(false);
        book.setBorderPainted(false);
        book.setFocusPainted(false); 
		p1.add(book);
		
		
		
		heading10 = new JLabel(packages[10]);
		heading10.setBounds(750,450,300,40);
		heading10.setFont(new Font("" , Font.BOLD , 32));
		heading10.setForeground(Color.magenta);
		p1.add(heading10);
		
		heading11 = new JLabel(packages[11]);
		heading11.setBounds(780,480,300,40);
		heading11.setFont(new Font("Tahoma" , Font.BOLD , 24));
		heading11.setForeground(Color.blue);
		p1.add(heading11);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(packages[0]));
		Image i2 = i1.getImage().getScaledInstance(600, 450, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel i4 = new JLabel(i3);
		i4.setBounds(550 , 80 , 550 ,330);
		p1.add(i4);
		
		
		return p1;
	}

	public static void main(String[] args) {
		Check_Package obj = new Check_Package();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	


}
