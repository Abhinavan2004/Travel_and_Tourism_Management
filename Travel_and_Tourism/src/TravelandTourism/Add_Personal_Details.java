package TravelandTourism;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Add_Personal_Details extends JFrame implements ActionListener {
    JLabel heading ,username, id, number, name, gender, country, add, phone, email;
    JButton addd, back;
    JRadioButton radio1, radio2;
    JComboBox<String> dropdown;
    JTextField usernamet, namet, numbert, countryt, addt, phonet, emailt;

    String usernamee;
    Conn co;

    Add_Personal_Details(String usernamee) {
        this.usernamee = usernamee;

        // Frame Settings
        setTitle("Add Personal Details");
        setBounds(350, 150, 900, 600);
        setLayout(null);

        // Labels
        heading = new JLabel("|| ADD YOUR DETAILS ||", JLabel.CENTER);
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        heading.setForeground(new Color(0, 102, 204)); // Optional styling
        heading.setBounds(0, 0, 900, 30); // Centered horizontally and positioned at the top
        add(heading);

        username = new JLabel("Username");
        id = new JLabel("ID Type");
        number = new JLabel("ID Number");
        name = new JLabel("Name");
        gender = new JLabel("Gender");
        country = new JLabel("Country");
        add = new JLabel("Address");
        phone = new JLabel("Phone No.");
        email = new JLabel("Email");

        JLabel[] labels = {username, id, number, name, gender, country, add, phone, email};
        for (JLabel label : labels) {
            label.setFont(new Font("Tahoma", Font.BOLD, 14));
        }

        // Text Fields
        usernamet = new JTextField(30);
        usernamet.setEditable(false);
        namet = new JTextField(20);
        namet.setEditable(false);
        numbert = new JTextField(20);
        countryt = new JTextField(20);
        addt = new JTextField(20);
        phonet = new JTextField(20);
        emailt = new JTextField(20);

        // Buttons
        addd = new JButton("ADD");
        back = new JButton("BACK");
        addd.addActionListener(this);
        back.addActionListener(this);

        // Gender Radio Buttons
        radio1 = new JRadioButton("Male");
        radio2 = new JRadioButton("Female");
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(radio1);
        radioGroup.add(radio2);

        // Dropdown
        String[] options = {"Passport", "Aadhar Card", "PAN Card"};
        dropdown = new JComboBox<>(options);

        // Setting Bounds for Labels and Fields
        int x1 = 50, x2 = 200, y = 50, width = 150, height = 30;
        int spacing = 50;

    
        username.setBounds(x1, y, width, height);
        usernamet.setBounds(x2, y, 250, height);

        id.setBounds(x1, y += spacing, width, height);
        dropdown.setBounds(x2, y, 250, height);

        number.setBounds(x1, y += spacing, width, height);
        numbert.setBounds(x2, y, 250, height);

        name.setBounds(x1, y += spacing, width, height);
        namet.setBounds(x2, y, 250, height);

        gender.setBounds(x1, y += spacing, width, height);
        radio1.setBounds(x2, y, 80, height);
        radio2.setBounds(x2 + 100, y, 100, height);

        country.setBounds(x1, y += spacing, width, height);
        countryt.setBounds(x2, y, 250, height);

        add.setBounds(x1, y += spacing, width, height);
        addt.setBounds(x2, y, 250, height);

        phone.setBounds(x1, y += spacing, width, height);
        phonet.setBounds(x2, y, 250, height);

        email.setBounds(x1, y += spacing, width, height);
        emailt.setBounds(x2, y, 250, height);

        // Buttons
        addd.setBounds(x2, y += spacing, 80, height);
        back.setBounds(x2 + 100, y, 80, height);

        // Image Panel (35% of Width)
        try {    		
        	ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("account.png"));
        	Image i2 = imageIcon.getImage().getScaledInstance(450, 250, Image.SCALE_DEFAULT);
        	ImageIcon i3 = new ImageIcon(i2);
            JLabel imageLabel = new JLabel(i3);
            imageLabel.setBounds(490, 120, 450, 250); // 35% Width for image
            add(imageLabel);
        } catch (Exception e) {
            JLabel errorLabel = new JLabel("Image not found");
            errorLabel.setBounds(520, 50, 330, 500);
            add(errorLabel);
        }

        // Adding Components to Frame
        add(username);
        add(usernamet);
        add(id);
        add(dropdown);
        add(number);
        add(numbert);
        add(name);
        add(namet);
        add(gender);
        add(radio1);
        add(radio2);
        add(country);
        add(countryt);
        add(add);
        add(addt);
        add(phone);
        add(phonet);
        add(email);
        add(emailt);
        add(addd);
        add(back);

        // Pre-fill Username and Name from Database
        try {
            co = new Conn();
            ResultSet rs = co.s.executeQuery("SELECT * FROM account WHERE username = '" + usernamee + "'");
            if (rs.next()) {
                usernamet.setText(rs.getString("username"));
                namet.setText(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new Add_Personal_Details("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
        }

        if (e.getSource() == addd) {
            try {
                String usernamesql = usernamet.getText();
                String idsql = (String) dropdown.getSelectedItem();
                String id_numsql = numbert.getText();
                String namesql = namet.getText();
                String gendersql = radio1.isSelected() ? "Male" : "Female";
                String countrysql = countryt.getText();
                String addresssql = addt.getText();
                String contactsql = phonet.getText();
                String emailsql = emailt.getText();

                if (usernamesql.isEmpty() || idsql.isEmpty() || id_numsql.isEmpty() || namesql.isEmpty() || gendersql.isEmpty() || countrysql.isEmpty() || addresssql.isEmpty() || contactsql.isEmpty() || emailsql.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all the fields", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String query = "INSERT INTO customer (username, id, id_number, name, gender, country, address, contact_no, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = co.getConnection().prepareStatement(query);
                stmt.setString(1, usernamesql);
                stmt.setString(2, idsql);
                stmt.setString(3, id_numsql);
                stmt.setString(4, namesql);
                stmt.setString(5, gendersql);
                stmt.setString(6, countrysql);
                stmt.setString(7, addresssql);
                stmt.setString(8, contactsql);
                stmt.setString(9, emailsql);

                stmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Account Details for '" + usernamesql + "' added successfully");
                setVisible(false);

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed to add details");
            }
        }
    }
}
