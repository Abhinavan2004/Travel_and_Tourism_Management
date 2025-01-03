//package TravelandTourism;
//
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import javax.swing.event.*;
//import java.net.*;
//
//public class Paytm extends JFrame implements ActionListener {
//
//    JButton back;
//    JEditorPane pane;
//
//    Paytm() {
//        setLayout(new BorderLayout());
//
//        pane = new JEditorPane();
//        pane.setEditable(false);
//
//        try {
//            pane.setPage(new URL("https://paytm.com/electricity-bill-payment"));
//        } catch (Exception e) {
//            pane.setContentType("text/html");
//            pane.setText("<html><h1>Failed to load the page!</h1><p>Please try again later.</p></html>");
//            e.printStackTrace();
//        }
//
//        JScrollPane scrollPane = new JScrollPane(pane);
//        add(scrollPane, BorderLayout.CENTER);
//
//        back = new JButton("BACK");
//        back.setFont(new Font("Tahoma", Font.BOLD, 16));
//        back.addActionListener(this);
//        add(back, BorderLayout.SOUTH);
//
//        setBounds(350, 180, 870, 625);
//        setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == back) {
//            setVisible(false);
//            new Payment();
//        }
//    }
//
//    public static void main(String[] args) {
//        new Paytm();
//    }
//}



package TravelandTourism;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

public class Paytm extends JFrame implements ActionListener {

    JButton back, openInBrowser;

    Paytm() {
        setLayout(null);
        
        // Label to inform users
        JLabel label = new JLabel("Click 'Open in Browser' to visit the Paytm page.");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Tahoma", Font.PLAIN, 18));
        label.setBounds(50,80,400,40);
        add(label);
        

        // Buttons panel
//JPanel buttonPanel = new JPanel();
        back = new JButton("BACK");
        back.setFont(new Font("Tahoma", Font.BOLD, 16));
        back.addActionListener(this);
        back.setBounds(80,210,100,30);

        openInBrowser = new JButton("OPEN IN BROWSER");
        openInBrowser.setFont(new Font("Tahoma", Font.BOLD, 16));
        openInBrowser.addActionListener(this);
        openInBrowser.setBounds(200,210,240,30);
        

        add(back);
        add(openInBrowser);
        
        setBounds(350, 150, 500, 300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
            new Payment(); // Assuming Payment is another class in your project
        } else if (e.getSource() == openInBrowser) {
            try {
                Desktop.getDesktop().browse(new URI("https://paytm.com/electricity-bill-payment"));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Unable to open the browser. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Paytm();
    }
}

