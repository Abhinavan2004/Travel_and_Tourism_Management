package TravelandTourism;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import java.awt.*;

public class View_Booked_Package extends JFrame implements ActionListener{

	JLabel heading, username , id , id_num , name , packagess , no_persons  , phone , price;
	JTextField usernamet , idt , id_numt , namet ,packagesst , no_personst , phonet , pricet ;
	JButton back ;
	String usernamebooked;
	Conn co ;
	
	View_Booked_Package(String usernamebooked){
this.usernamebooked = usernamebooked;
		
		setLayout(null);

		    heading = new JLabel("||   VIEW BOOKED PACKAGE ||");
		    heading.setFont(new Font("Tahoma" , Font.BOLD , 24));
		    heading.setBounds(270,0,600,50);
		    
		    username = new JLabel("Username");
	        username.setFont(new Font("Tahoma", Font.BOLD, 14));
	        username.setBounds(50, 80, 120, 25);
	        
	        packagess = new JLabel("Packages");
	        packagess.setFont(new Font("Tahoma", Font.BOLD, 14));
	        packagess.setBounds(50, 130 , 120 ,25);
	        
	        no_persons = new JLabel("No of Persons");
	        no_persons.setFont(new Font("Tahoma", Font.BOLD, 14));
	        no_persons.setBounds(50, 180, 120, 25);

	        id = new JLabel("ID Type");
	        id.setFont(new Font("Tahoma", Font.BOLD, 14));
	        id.setBounds(50, 230, 120, 25);

	        id_num = new JLabel("ID Number");
	        id_num.setFont(new Font("Tahoma", Font.BOLD, 14));
	        id_num.setBounds(50, 280, 120, 25);

	        phone = new JLabel("Phone No.");
	        phone.setFont(new Font("Tahoma", Font.BOLD, 14));
	        phone.setBounds(50, 330, 120, 25);

	        price = new JLabel("Price");
	        price.setBounds(50, 380, 120, 25);
	        price.setFont(new Font("Tahoma", Font.BOLD, 14));
	        

	        
	      
	        usernamet = new JTextField(30);
	        usernamet.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        usernamet.setBounds(200, 80, 200, 30);
             usernamet.setEditable(false);
             
             packagesst = new JTextField(30);
 	        packagesst.setFont(new Font("Tahoma", Font.PLAIN, 14));
 	        packagesst.setBounds(200, 130, 200, 30);
              packagesst.setEditable(false);
              
              no_personst = new JTextField(30);
  	        no_personst.setFont(new Font("Tahoma", Font.PLAIN, 14));
  	        no_personst.setBounds(200, 180, 200, 30);
               no_personst.setEditable(false);

	        idt = new JTextField(30);
	        idt.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        idt.setBounds(200, 230, 200, 30);
             idt.setEditable(false);
             

	        id_numt = new JTextField(30);
	        id_numt.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        id_numt.setBounds(200, 280, 200, 30);
             id_numt.setEditable(false);

	        phonet = new JTextField(30);
	        phonet.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        phonet.setBounds(200, 330, 200, 30);
            phonet.setEditable(false);

	        pricet = new JTextField(30);
	        pricet.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        pricet.setBounds(200, 380, 200, 30);
            pricet.setEditable(false);

	        back = new JButton("BACK");
	        back.setFont(new Font("Tahoma", Font.BOLD, 14));
	        back.addActionListener(this);
	        back.setBounds(250 , 520 , 100 ,30);
	        back.setBackground(Color.black);
	        back.setForeground(Color.white);

	        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bookedDetails.jpg"));
		    Image i2 = i1.getImage().getScaledInstance(430, 550, Image.SCALE_DEFAULT);
		    ImageIcon i3 = new ImageIcon(i2);
	        JLabel i4 = new JLabel(i3);
	        i4.setBounds(430 , 80 , 430 , 550);
	        add(i4);
	        
	        add(heading);
	        add(username);
	        add(usernamet);
	        add(packagess);
	        add(packagesst);
	        add(no_persons);
	        add(no_personst);
	        add(id);
	        add(idt);
	        add(id_num);
	        add(id_numt);
	        add(phone);
	        add(phonet);
	        add(price);
	        add(pricet);
	        
	        add(back);

	
	        co = new Conn();
			
			try {
				ResultSet rs = co.s.executeQuery("SELECT * FROM bookpackage WHERE username = '" + usernamebooked+"'");
				
				if(rs.next()) {
	                usernamet.setText(rs.getString("username"));
	                idt.setText(rs.getString("id"));
	                id_numt.setText(rs.getString("id_number"));
	                packagesst.setText(rs.getString("package"));
	                pricet.setText(rs.getString("price"));
	                no_personst.setText(rs.getString("persons"));
	                phonet.setText(rs.getString("contact_no"));
	                      
				}
			}
			catch(Exception ae) {
				ae.printStackTrace();
			}
		
		
        setVisible(true);
        setBounds(350 , 150 , 870 ,625 );
        setTitle("View Page");
		
	}
	public static void main(String[] args) {
		View_Booked_Package obj = new View_Booked_Package("");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(back == e.getSource()) {
			setVisible(false);
		}
		
	}

}
