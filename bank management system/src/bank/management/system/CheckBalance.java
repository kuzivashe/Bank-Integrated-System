
package bank.management.system;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class CheckBalance extends JFrame implements ActionListener {
    String pinnumber;
    JLabel label1, label2, label3;
    JButton back;
    CheckBalance(String pinnumber) {
        this.pinnumber = pinnumber;
        setTitle("Check Balance");
        setLayout(null);
        
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("images/cbz-holdings-logo.jpg"));
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("images/planets.jpg"));
        Image img1 = icon1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        Image img2 = icon2.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        Image img3 = icon5.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(img1);
        ImageIcon icon4 = new ImageIcon(img2);
        icon5 = new ImageIcon(img3);
        label1 = new JLabel(icon3);
        label2 = new JLabel(icon4);
        label3 = new JLabel(icon5);
        label1.setBounds(10, 10, 350, 130);
        label2.setBounds(310, 10, 350, 130);
        label3.setBounds(15, 170, 650, 300);
        add(label1);
        add(label2);
        add(label3);
        
        back = new JButton("Back");
        back.setBounds(260, 150, 120, 30);
        back.setBackground(Color.blue);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        label3.add(back);
        
        Conn c = new Conn();
        int balance = 0;
        try
        {
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        JLabel text = new JLabel("Your current account balance is RTGs " + balance);
        text.setBounds(160, 100, 350, 25);
        text.setFont(new Font("Arial", Font.BOLD, 16));
        text.setForeground(Color.white);
        label3.add(text);
        
        setSize(700, 570);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        
        getContentPane().setBackground(Color.white);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new CheckBalance("");
    }
}
