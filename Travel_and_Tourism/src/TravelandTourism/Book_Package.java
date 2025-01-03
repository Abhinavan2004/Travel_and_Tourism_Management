package TravelandTourism;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Book_Package extends JFrame implements ActionListener {
	
	JLabel heading , username , id , id_num , phone , pack , no_persons, tprice;
	JTextField usernamet , idt , id_numt , phonet  , no_personst, tpricet ;
	Choice packc ;
	JButton back , book , view;
	Conn co;
	String usernameview ;
	
	Book_Package(String usernameview){
		setLayout(null);
		this.usernameview = usernameview;
		

	    heading = new JLabel("||   BOOK YOUR PACKAGE  ||");
	    heading.setFont(new Font("Tahoma" , Font.BOLD , 24));
	    heading.setBounds(270,0,600,50);
	    
	    username = new JLabel("Username");
        username.setFont(new Font("Tahoma", Font.BOLD, 16));
        username.setBounds(50, 100, 180, 25);

        pack = new JLabel("Select Package");
        pack.setFont(new Font("Tahoma", Font.BOLD, 16));
        pack.setBounds(50, 150, 150, 25);
        
        no_persons = new JLabel("Total Persons");
        no_persons.setFont(new Font("Tahoma", Font.BOLD, 16));
        no_persons.setBounds(50, 200, 180, 25);
        
        id = new JLabel("ID Type");
        id.setFont(new Font("Tahoma", Font.BOLD, 16));
        id.setBounds(50, 250, 180, 25);

        id_num = new JLabel("ID Number");
        id_num.setFont(new Font("Tahoma", Font.BOLD, 16));
        id_num.setBounds(50, 300, 180, 25);

        phone = new JLabel("Phone No.");
        phone.setFont(new Font("Tahoma", Font.BOLD, 16));
        phone.setBounds(50, 350, 180, 25);
        
        tprice = new JLabel("Total Price");
        tprice.setFont(new Font("Tahoma", Font.BOLD, 16));
        tprice.setBounds(50, 400, 180, 25);

        
      
        usernamet = new JTextField(30);
        usernamet.setFont(new Font("Tahoma", Font.PLAIN, 14));
        usernamet.setBounds(200, 100, 200, 30);
        usernamet.setEditable(false);

        idt = new JTextField(30);
        idt.setFont(new Font("Tahoma", Font.PLAIN, 14));
        idt.setBounds(200, 250, 200, 30);
        idt.setEditable(false);
         
         packc = new Choice();
         packc.add("GOLD PACKAGE");
         packc.add("SILVER PACKAGE");
         packc.add("BRONZE PACKAGE");
         packc.setFont(new Font("Tahoma", Font.PLAIN, 14));
         packc.setBounds(200, 150, 200, 30);
          
         no_personst = new JTextField(30);
         no_personst.setFont(new Font("Tahoma", Font.PLAIN, 14));
         no_personst.setBounds(200, 200, 200, 30);

        id_numt = new JTextField(30);
        id_numt.setFont(new Font("Tahoma", Font.PLAIN, 14));
        id_numt.setBounds(200, 300, 200, 30);
         id_numt.setEditable(false);

        phonet = new JTextField(30);
        phonet.setFont(new Font("Tahoma", Font.PLAIN, 14));
        phonet.setBounds(200, 350, 200, 30);
        phonet.setEditable(false);
        
        tpricet = new JTextField(30);
        tpricet.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tpricet.setBounds(200, 400, 200, 30);
        tpricet.setEditable(false);
        
        
        
        view = new JButton("VIEW PRICE");
        view.setFont(new Font("Tahoma", Font.BOLD, 14));
        view.addActionListener(this);
        view.setBounds(150 , 500 , 150 ,30);
        view.setBackground(Color.black);
        view.setForeground(Color.white);
        
        book = new JButton("BOOK PACKAGE");
        book.setFont(new Font("Tahoma", Font.BOLD, 14));
        book.addActionListener(this);
        book.setBounds(350 , 500 , 150 ,30);
        book.setBackground(Color.black);
        book.setForeground(Color.white);
        
        back = new JButton("BACK");
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.addActionListener(this);
        back.setBounds(550 , 500 , 150 ,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);

        
        add(heading);
        add(username);
        add(usernamet);
        add(pack);
        add(packc);
        add(no_persons);
        add(no_personst);
        add(id);
        add(idt);
        add(id_num);
        add(id_numt);
        add(phone);
        add(phonet);
        add(tprice);
        add(tpricet);
        add(view);
        add(book);
        add(back);
        
        
        co = new Conn();
		
		try {
			ResultSet rs = co.s.executeQuery("SELECT * FROM customer WHERE username = '" + usernameview+"'");
			
			if(rs.next()) {
                usernamet.setText(rs.getString("username"));
                idt.setText(rs.getString("id"));
                id_numt.setText(rs.getString("id_number"));
                phonet.setText(rs.getString("contact_no"));
                     
			}
		}
		catch(Exception ae) {
			ae.printStackTrace();
		}
      
		setVisible(true);
        setBounds(350 , 150 , 870 ,625 );
        setTitle("Book Package");		
	}

	public static void main(String[] args) {
		Book_Package obj = new Book_Package("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(back == e.getSource()) {
			setVisible(false);
		}
		if(view == e.getSource()) {
			int cost = 0 ;
			if(packc.getSelectedItem() == "GOLD PACKAGE") {
				cost = cost + 12000;
			}
			else if(packc.getSelectedItem() == "SILVER PACKAGE") {
				cost  = cost + 25000;
			}
			else if(packc.getSelectedItem() == "BRONZE PACKAGE") {
				 cost = cost + 32000;
			}
			
			int persons = Integer.parseInt(no_personst.getText());
			cost = cost * persons;
			tpricet.setText("Rs " + cost);
		}
		if(book == e.getSource()) {
			
			co = new Conn();
			
			try {
				String query = "INSERT INTO bookpackage VALUES('"+usernamet.getText()+"', '"+packc.getSelectedItem()+"', '"+no_personst.getText()+"', '"+idt.getText()+"', '"+id_numt.getText()+"', '"+phonet.getText()+"', '"+tpricet.getText()+"')";
			    co.s.executeUpdate(query);
			   
			} catch (SQLException e1) { JOptionPane.showMessageDialog(null, "Package Booked Successfully!!");
			    setVisible(false);
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Failed to Book Package");
			}
			
		}
	}

}
