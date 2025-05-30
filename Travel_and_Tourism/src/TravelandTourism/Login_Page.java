package TravelandTourism;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;


public class Login_Page extends JFrame implements ActionListener {
	JPanel imagep , formp , buttonp;
	JButton login , signup , forget ;
	JTextField usernamet , passwordt ;
	JLabel username , password , trouble ;
	Conn co ;
	
	Login_Page(){
		co = new Conn();
		
		imagep = new JPanel();
		formp = new JPanel(new GridLayout(5,1,10,10));
		buttonp = new JPanel(new BorderLayout(20,20));
		
		username = new JLabel("Username");
		username.setFont(new Font("Tahoma" , Font.PLAIN , 24));
		password = new JLabel("Password");
		password.setFont(new Font("Tahoma" , Font.PLAIN , 24));
		trouble = new JLabel("Trouble in Logging...");
		trouble.setForeground(Color.red);
		trouble.setFont(new Font("Tahoma" , Font.BOLD , 10));
		
		usernamet = new JTextField();
		usernamet.setFont(new Font("Tahoma" , Font.PLAIN , 16));
		usernamet.setBounds(60,60,300,30);
		passwordt = new JTextField(20);
		passwordt.setFont(new Font("Tahoma" , Font.PLAIN , 16));
		
		
		login = new JButton("Login");
		login.setFont(new Font("Tahoma" , Font.BOLD , 16));
		login.addActionListener(this);
		signup = new JButton("SignUp");
		signup.setFont(new Font("Tahoma" , Font.BOLD , 16));
		signup.addActionListener(this);
		forget = new JButton("Forgot Password");
		forget.setFont(new Font("Tahoma" , Font.BOLD , 18));
		forget.addActionListener(this);
		
		
		formp.add(username);
		formp.add(usernamet);
		formp.add(password);
		formp.add(passwordt);
		
		buttonp.add(login, BorderLayout.EAST);
		buttonp.add(signup , BorderLayout.WEST);
		buttonp.add(forget , BorderLayout.SOUTH);
		buttonp.add(trouble);

		
		formp.add(buttonp);
		
		 try {
	            ImageIcon imageIcon = new ImageIcon("C:\\Users\\user\\Downloads\\Online Registration.jpg");
	            JLabel imageLabel = new JLabel(imageIcon);
	            imagep.add(imageLabel); // Add the image to the panel
	        } catch (Exception e) {
	            JLabel errorLabel = new JLabel("Image not found");
	            imagep.add(errorLabel); // Display error message if image is not found
	        }
		
	
        setBounds(350, 200, 900, 540);
		setLayout(new FlowLayout());
		add(imagep);
		add(formp);
		
		setVisible(true);
		setTitle("LOGIN PAGE");
	}

	public static void main(String[] args) {
		Login_Page obj = new Login_Page();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == signup) {
			setVisible(false);
			new Sign_Up_Page();
		}
		if(e.getSource() == login){
			
			String usernamesql = usernamet.getText();
			String passwordsql = passwordt.getText();
			
			  if (usernamesql.isEmpty() || passwordsql.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Please Enter the Required Information");
		            return; 
		        }
			try {
			String query ="SELECT * FROM account WHERE username = ? AND password = ?";
			
            PreparedStatement stmt = co.getConnection().prepareStatement(query);
            stmt.setString(1, usernamesql);
            stmt.setString(2, passwordsql);
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()) {
            	setVisible(false);
            	JOptionPane.showMessageDialog(null, "Account Found\nLogin Successfull");
            	new Dashboard(usernamesql);
            	
            }
            
            else {
            	JOptionPane.showMessageDialog(null, "Invalid Username or Password");
            }
			}
			catch(Exception ae) {
				ae.printStackTrace();
                JOptionPane.showMessageDialog(this, "Database connection error.");
			}
			
			
		}
		if(e.getSource() == forget) {
			setVisible(false);
			new Password_Recovery();
		}
		
	}

}
