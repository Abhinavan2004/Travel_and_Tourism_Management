package TravelandTourism;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class View_Booked_Hotel extends JFrame implements ActionListener {


	JLabel heading, username , id , id_num , name , packagess , food , ac_nac , no_days , no_persons  , phone , price;
	JTextField usernamet , idt , id_numt , namet ,packagesst , no_personst ,no_dayst , foodt , ac_nact , phonet , pricet ;
	JButton back ;
	String usernamebookedhotel;
	Conn co ;
	
	View_Booked_Hotel(String usernamebookedhotel){
this.usernamebookedhotel = usernamebookedhotel;
		
		setLayout(null);

		    heading = new JLabel("||   VIEW BOOKED HOTEL ||");
		    heading.setFont(new Font("Tahoma" , Font.BOLD , 24));
		    heading.setBounds(270,0,600,50);
		    
		    username = new JLabel("Username");
	        username.setFont(new Font("Tahoma", Font.BOLD, 14));
	        username.setBounds(50, 80, 120, 25);
	        
	        packagess = new JLabel("Hotel Name");
	        packagess.setFont(new Font("Tahoma", Font.BOLD, 14));
	        packagess.setBounds(50, 130 , 120 ,25);
	        
	        no_persons = new JLabel("Total Persons");
	        no_persons.setFont(new Font("Tahoma", Font.BOLD, 14));
	        no_persons.setBounds(50, 180, 120, 25);
	        
	        no_days = new JLabel("Total Days");
	        no_days.setFont(new Font("Tahoma", Font.BOLD, 14));
	        no_days.setBounds(50, 230, 120, 25);
	        
	        food = new JLabel("Food Included?");
	        food.setFont(new Font("Tahoma", Font.BOLD, 14));
	        food.setBounds(50, 280, 120, 25);
	        
	        ac_nac = new JLabel("AC / Non-AC ?");
	        ac_nac.setFont(new Font("Tahoma", Font.BOLD, 14));
	        ac_nac.setBounds(50, 330, 120, 25);

	        id = new JLabel("ID Type");
	        id.setFont(new Font("Tahoma", Font.BOLD, 14));
	        id.setBounds(50, 380, 120, 25);

	        id_num = new JLabel("ID Number");
	        id_num.setFont(new Font("Tahoma", Font.BOLD, 14));
	        id_num.setBounds(50, 430, 120, 25);

	        phone = new JLabel("Phone No.");
	        phone.setFont(new Font("Tahoma", Font.BOLD, 14));
	        phone.setBounds(50, 480, 120, 25);

	        price = new JLabel("Price");
	        price.setBounds(50, 530, 120, 25);
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
               
               no_dayst = new JTextField(30);
     	        no_dayst.setFont(new Font("Tahoma", Font.PLAIN, 14));
     	        no_dayst.setBounds(200, 230, 200, 30);
                  no_dayst.setEditable(false);
                  
                  foodt = new JTextField(30);
        	        foodt.setFont(new Font("Tahoma", Font.PLAIN, 14));
        	        foodt.setBounds(200, 280, 200, 30);
                     foodt.setEditable(false);
                     
                     ac_nact = new JTextField(30);
           	        ac_nact.setFont(new Font("Tahoma", Font.PLAIN, 14));
           	        ac_nact.setBounds(200, 330, 200, 30);
                        ac_nact.setEditable(false);

	        idt = new JTextField(30);
	        idt.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        idt.setBounds(200, 380, 200, 30);
             idt.setEditable(false);
             

	        id_numt = new JTextField(30);
	        id_numt.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        id_numt.setBounds(200, 430, 200, 30);
             id_numt.setEditable(false);

	        phonet = new JTextField(30);
	        phonet.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        phonet.setBounds(200, 480, 200, 30);
            phonet.setEditable(false);

	        pricet = new JTextField(30);
	        pricet.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        pricet.setBounds(200, 530, 200, 30);
            pricet.setEditable(false);

	        back = new JButton("BACK");
	        back.setFont(new Font("Tahoma", Font.BOLD, 14));
	        back.addActionListener(this);
	        back.setBounds(250 , 600 , 100 ,30);
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
	        add(no_days);
	        add(no_dayst);
	        add(food);
	        add(foodt);
	        add(ac_nac);
	        add(ac_nact);
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
				ResultSet rs = co.s.executeQuery("SELECT * FROM hotelpackage WHERE username = '" + usernamebookedhotel+"'");
				
				if(rs.next()) {
	                usernamet.setText(rs.getString("username"));
	                idt.setText(rs.getString("id"));
	                id_numt.setText(rs.getString("id_number"));
	                packagesst.setText(rs.getString("hotelname"));
	                no_dayst.setText(rs.getString("no_days"));
	                foodt.setText(rs.getString("food"));
	                ac_nact.setText(rs.getString("ac_nac"));
	                pricet.setText(rs.getString("price"));
	                no_personst.setText(rs.getString("persons"));
	                phonet.setText(rs.getString("contact_no"));
	                      
				}
			}
			catch(Exception ae) {
				ae.printStackTrace();
			}
		
		
        setVisible(true);
        setBounds(350 , 120 , 870 ,675 );
        setTitle("View Booked Hotel");
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		View_Booked_Hotel obj = new View_Booked_Hotel("");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(back == e.getSource()) {
			setVisible(false);
		}
	}

}
