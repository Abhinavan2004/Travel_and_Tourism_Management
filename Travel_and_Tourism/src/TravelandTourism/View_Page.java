package TravelandTourism;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class View_Page extends JFrame implements ActionListener {
	
	JLabel heading, username , id , id_num , name ,gender ,country , address , phone , email ;
	JTextField usernamet , idt , id_numt , namet ,gendert ,countryt , addresst , phonet , emailt ;
	JButton back ;
	JPanel formp , imagep;
	String usernameview;
	Conn co ;
	
	
	View_Page(String usernameview){
		
		this.usernameview = usernameview;
		
		setLayout(null);

		    heading = new JLabel("||   VIEW YOUR PROFILE  ||");
		    heading.setFont(new Font("Tahoma" , Font.BOLD , 24));
		    heading.setBounds(270,0,600,50);
		    
		    username = new JLabel("Username");
	        username.setFont(new Font("Tahoma", Font.BOLD, 14));
	        username.setBounds(50, 50, 120, 25);

	        id = new JLabel("ID Type");
	        id.setFont(new Font("Tahoma", Font.BOLD, 14));
	        id.setBounds(50, 100, 120, 25);

	        id_num = new JLabel("ID Number");
	        id_num.setFont(new Font("Tahoma", Font.BOLD, 14));
	        id_num.setBounds(50, 150, 120, 25);

	        name = new JLabel("Name");
	        name.setFont(new Font("Tahoma", Font.BOLD, 14));
	        name.setBounds(50, 200, 120, 25);

	        gender = new JLabel("Gender");
	        gender.setFont(new Font("Tahoma", Font.BOLD, 14));
	        gender.setBounds(50, 250, 120, 25);

	        country = new JLabel("Country");
	        country.setFont(new Font("Tahoma", Font.BOLD, 14));
	        country.setBounds(50, 300, 120, 25);

	        address = new JLabel("Address");
	        address.setFont(new Font("Tahoma", Font.BOLD, 14));
	        address.setBounds(50, 350, 120, 25);

	        phone = new JLabel("Phone No.");
	        phone.setFont(new Font("Tahoma", Font.BOLD, 14));
	        phone.setBounds(50, 400, 120, 25);

	        email = new JLabel("Email");
	        email.setFont(new Font("Tahoma", Font.BOLD, 14));
	        email.setBounds(50, 450, 120, 25);
	        

	        usernamet = new JTextField(30);
	        usernamet.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        usernamet.setBounds(200, 50, 200, 30);
             usernamet.setEditable(false);

	        idt = new JTextField(30);
	        idt.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        idt.setBounds(200, 100, 200, 30);
             idt.setEditable(false);
             

	        id_numt = new JTextField(30);
	        id_numt.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        id_numt.setBounds(200, 150, 200, 30);
             id_numt.setEditable(false);

	        namet = new JTextField(30);
	        namet.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        namet.setBounds(200, 200, 200, 30);
             namet.setEditable(false);

	        gendert = new JTextField(30);
	        gendert.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        gendert.setBounds(200, 250, 200, 30);
             gendert.setEditable(false);

	        countryt = new JTextField(30);
	        countryt.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        countryt.setBounds(200, 300, 200, 30);
            countryt.setEditable(false);

	        addresst = new JTextField(30);
	        addresst.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        addresst.setBounds(200, 350, 200, 30);
            addresst.setEditable(false);

	        phonet = new JTextField(30);
	        phonet.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        phonet.setBounds(200, 400, 200, 30);
            phonet.setEditable(false);

	        emailt = new JTextField(30);
	        emailt.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        emailt.setBounds(200, 450, 200, 30);
            emailt.setEditable(false);

	        back = new JButton("BACK");
	        back.setFont(new Font("Tahoma", Font.BOLD, 14));
	        back.addActionListener(this);
	        back.setBounds(370 , 520 , 100 ,30);
	        back.setBackground(Color.black);
	        back.setForeground(Color.white);

	        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("view_details_img.png"));
		    Image i2 = i1.getImage().getScaledInstance(330, 300, Image.SCALE_DEFAULT);
		    ImageIcon i3 = new ImageIcon(i2);
	        JLabel i4 = new JLabel(i3);
	        i4.setBounds(470 , 100 , 310,310);
	        add(i4);
	        
	        add(heading);
	        add(username);
	        add(usernamet);
	        add(id);
	        add(idt);
	        add(id_num);
	        add(id_numt);
	        add(name);
	        add(namet);
	        add(gender);
	        add(gendert);
	        add(country);
	        add(countryt);
	        add(address);
	        add(addresst);
	        add(phone);
	        add(phonet);
	        add(email);
	        add(emailt);
	        
	        add(back);

	
	        co = new Conn();
			
			try {
				ResultSet rs = co.s.executeQuery("SELECT * FROM customer WHERE username = '" + usernameview+"'");
				
				if(rs.next()) {
	                usernamet.setText(rs.getString("username"));
	                idt.setText(rs.getString("id"));
	                id_numt.setText(rs.getString("id_number"));
	                namet.setText(rs.getString("name"));
	                gendert.setText(rs.getString("gender"));
	                countryt.setText(rs.getString("country"));
	                addresst.setText(rs.getString("address"));
	                phonet.setText(rs.getString("contact_no"));
	                emailt.setText(rs.getString("email"));      
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
		View_Page obj = new View_Page("");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == back) {
			setVisible(false);
		}
		
	
		
	}

}