package TravelandTourism;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sign_Up_Page extends JFrame implements ActionListener {
    JLabel user, name, password, security, answer;
    JTextField usert, namet, passwordt, answert;
    JButton create, back;
    JPanel formPanel, imagePanel;
    JComboBox<String> security_dd;

    Sign_Up_Page() {
        setTitle("Sign Up Page");
        setLayout(null); // Using absolute layout
        setBounds(350, 250, 900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Form Panel (65% Width)
        formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBackground(new Color(173, 216, 230));
        formPanel.setBounds(0, 0, 585, 500); // 65% of 900 = 585px
        add(formPanel);

        // Labels and TextFields for form
        int labelX = 50, textFieldX = 250, y = 50, height = 30, width = 250;
        user = new JLabel("Username:");
        user.setFont(new Font("Tahoma", Font.BOLD, 16));
        user.setBounds(labelX, y, width, height);
        formPanel.add(user);

        usert = new JTextField();
        usert.setFont(new Font("Tahoma", Font.PLAIN, 16));
        usert.setBounds(textFieldX, y, width, height);
        formPanel.add(usert);

        name = new JLabel("Name:");
        name.setFont(new Font("Tahoma", Font.BOLD, 16));
        name.setBounds(labelX, y + 50, width, height);
        formPanel.add(name);

        namet = new JTextField();
        namet.setFont(new Font("Tahoma", Font.PLAIN, 16));
        namet.setBounds(textFieldX, y + 50, width, height);
        formPanel.add(namet);

        password = new JLabel("Password:");
        password.setFont(new Font("Tahoma", Font.BOLD, 16));
        password.setBounds(labelX, y + 100, width, height);
        formPanel.add(password);

        passwordt = new JTextField();
        passwordt.setFont(new Font("Tahoma", Font.PLAIN, 16));
        passwordt.setBounds(textFieldX, y + 100, width, height);
        formPanel.add(passwordt);

        security = new JLabel("Security Question:");
        security.setFont(new Font("Tahoma", Font.BOLD, 16));
        security.setBounds(labelX, y + 150, width + 50, height);
        formPanel.add(security);

        String[] options = {"Which is your Favourite Anime?", "What is your Pet Name?", "Which is your Fav. Food?"};
        security_dd = new JComboBox<>(options);
        security_dd.setFont(new Font("Tahoma", Font.PLAIN, 16));
        security_dd.setBounds(textFieldX, y + 150, width, height);
        formPanel.add(security_dd);

        answer = new JLabel("Answer:");
        answer.setFont(new Font("Tahoma", Font.BOLD, 16));
        answer.setBounds(labelX, y + 200, width, height);
        formPanel.add(answer);

        answert = new JTextField();
        answert.setFont(new Font("Tahoma", Font.PLAIN, 16));
        answert.setBounds(textFieldX, y + 200, width, height);
        formPanel.add(answert);

        // Buttons
        create = new JButton("Create");
        create.setFont(new Font("Arial", Font.BOLD, 16));
        create.setBounds(150, y + 280, 100, height);
        create.addActionListener(this);
        formPanel.add(create);

        back = new JButton("Back");
        back.setFont(new Font("Arial", Font.BOLD, 16));
        back.setBounds(300, y + 280, 100, height);
        back.addActionListener(this);
        formPanel.add(back);

        // Image Panel (35% Width)
        imagePanel = new JPanel();
        imagePanel.setLayout(null);
        imagePanel.setBackground(Color.WHITE);
        imagePanel.setBounds(585, 0, 315, 500); // 35% of 900 = 315px
        add(imagePanel);

        try { 
            // Load and scale the image
        	ImageIcon imageIcon = new ImageIcon(getClass().getResource("/assets/Login.png"));
            Image scaledImage = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            JLabel imageLabel = new JLabel(scaledIcon);
            imageLabel.setBounds(7, 100, 300, 300); // Centered image
            imagePanel.add(imageLabel);
        } catch (Exception e) {
            JLabel errorLabel = new JLabel("Image not found", JLabel.CENTER);
            errorLabel.setBounds(50, 200, 200, 30);
            imagePanel.add(errorLabel);
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new Sign_Up_Page();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
            new Login_Page();
        }

        if (e.getSource() == create) {
            String usersql = usert.getText();
            String namesql = namet.getText();
            String passwordsql = passwordt.getText();
            String securitysql = (String) security_dd.getSelectedItem();
            String answersql = answert.getText();

            String query = "INSERT INTO account VALUES('" + usersql + "', '" + namesql + "', '" + passwordsql + "', '" + securitysql + "', '" + answersql + "')";
            try {
                Conn co = new Conn();
                co.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Account Created Successfully");

                setVisible(false);
                new Login_Page();
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
    }
}