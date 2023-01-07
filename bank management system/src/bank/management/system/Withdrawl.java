
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener {
    JLabel label1, label2, label3;
    String pinnumber;
    JButton withdraw, back;
    JTextField number;
    
    Withdrawl(String pinnumber) {
        this.pinnumber = pinnumber;
        setTitle("Banking Withdrawls");
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
        
        JLabel text = new JLabel("ENTER AMOUNT TO WITHDRAW");
        text.setBounds(195, 60, 300, 25);
        text.setFont(new Font("Arial", Font.BOLD, 18));
        text.setBackground(Color.white);
        text.setForeground(Color.black);
        label3.add(text);
        
        number = new JTextField();
        number.setBounds(195, 100, 250, 30);
        number.setFont(new Font("Arial", Font.BOLD, 14));
        number.addActionListener(this);
        label3.add(number);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(195, 150, 100, 30);
        withdraw.setBackground(Color.red);
        withdraw.setForeground(Color.WHITE);
        withdraw.addActionListener(this);
        label3.add(withdraw);
        
        back = new JButton("Back");
        back.setBounds(345, 150, 100, 30);
        back.setBackground(Color.blue);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        label3.add(back);
        
        setSize(700, 570);
        setLocation(300, 0);
        setVisible(true);
        
        getContentPane().setBackground(Color.white);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        try{        
            String amount = number.getText();
            Date date = new Date();
            if(ae.getSource() == withdraw){
                if(number.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                }else{
                    Conn c1 = new Conn();
                    c1.s.executeUpdate("insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "RTGs. "+amount+" withdrawn Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
            } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    public static void main(String[] args) {
        new Withdrawl("");
    }
    
}
