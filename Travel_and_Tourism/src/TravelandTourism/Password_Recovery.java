package TravelandTourism;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Password_Recovery extends JFrame implements ActionListener {
    // Fields for user inputs and buttons
    JTextField txtUsername, txtName, txtSecurityQuestion, txtAnswer, txtPassword;
    JButton btnSearch, btnRetrieve, btnBack;

    public Password_Recovery() {
        setTitle("Password Recovery");
        setLayout(null);

        // Components
        JLabel lblUsername = new JLabel("Username");
        txtUsername = new JTextField();
        btnSearch = new JButton("Search");

        JLabel lblName = new JLabel("Name");
        txtName = new JTextField();
        txtName.setEditable(false);

        JLabel lblSecurityQuestion = new JLabel("Your Security Question");
        txtSecurityQuestion = new JTextField();
        txtSecurityQuestion.setEditable(false);

        JLabel lblAnswer = new JLabel("Answer");
        txtAnswer = new JTextField();
        btnRetrieve = new JButton("Retrieve");

        JLabel lblPassword = new JLabel("Password");
        txtPassword = new JTextField();
        txtPassword.setEditable(false);

        btnBack = new JButton("Back");

        // Set bounds
        lblUsername.setBounds(30, 30, 150, 25);
        txtUsername.setBounds(200, 30, 150, 25);
        btnSearch.setBounds(360, 30, 100, 25);

        lblName.setBounds(30, 70, 150, 25);
        txtName.setBounds(200, 70, 260, 25);

        lblSecurityQuestion.setBounds(30, 110, 150, 25);
        txtSecurityQuestion.setBounds(200, 110, 260, 25);

        lblAnswer.setBounds(30, 150, 150, 25);
        txtAnswer.setBounds(200, 150, 150, 25);
        btnRetrieve.setBounds(360, 150, 100, 25);

        lblPassword.setBounds(30, 190, 150, 25);
        txtPassword.setBounds(200, 190, 260, 25);

        btnBack.setBounds(200, 240, 100, 30);

        // Add components to frame
        add(lblUsername);
        add(txtUsername);
        add(btnSearch);
        add(lblName);
        add(txtName);
        add(lblSecurityQuestion);
        add(txtSecurityQuestion);
        add(lblAnswer);
        add(txtAnswer);
        add(btnRetrieve);
        add(lblPassword);
        add(txtPassword);
        add(btnBack);

        // Add image
        ImageIcon originalIcon = new ImageIcon("C:\\Users\\user\\Downloads\\Online Registration.jpg");
        Image scaledImage = originalIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        JLabel iconLabel = new JLabel(new ImageIcon(scaledImage));
        iconLabel.setBounds(500, 50, 150, 150);
        add(iconLabel);

        // Add event listeners
        btnSearch.addActionListener(this);
        btnRetrieve.addActionListener(this);
        btnBack.addActionListener(this);

        // Frame properties
        setBounds(350,250,700, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Action listener for button clicks
    public void actionPerformed(ActionEvent ae) {
        try {
            Conn con = new Conn(); // Using your Conn class

            if (ae.getSource() == btnSearch) {
                // Query to fetch name and security question based on username
                String sql = "SELECT name, security_question FROM account WHERE username=?";
                PreparedStatement st = con.co.prepareStatement(sql);
                st.setString(1, txtUsername.getText());
                ResultSet rs = st.executeQuery();

                if (rs.next()) {
                    txtName.setText(rs.getString("name"));
                    txtSecurityQuestion.setText(rs.getString("security_question"));
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username");
                }
            }

            if (ae.getSource() == btnRetrieve) {
                // Query to validate answer and fetch the password
                String sql = "SELECT password FROM account WHERE username=? AND answer=?";
                PreparedStatement st = con.co.prepareStatement(sql);
                st.setString(1, txtUsername.getText());
                st.setString(2, txtAnswer.getText());
                ResultSet rs = st.executeQuery();

                if (rs.next()) {
                    txtPassword.setText(rs.getString("password"));
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Answer");
                }
            }

            if (ae.getSource() == btnBack) {
                
                setVisible(false);
                new Login_Page();
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Password_Recovery();
    }
}
