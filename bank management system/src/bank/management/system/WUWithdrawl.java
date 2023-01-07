
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class WUWithdrawl extends JFrame implements ActionListener {
    JLabel label1, label2, label3;
    String pinnumber;
    JButton withdraw, back;
    JTextField number;
    
    WUWithdrawl(String pinnumber) {
        this.pinnumber = pinnumber;
        setTitle("Remittance Withdrawls From Western Union");
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
        
        JLabel text = new JLabel("ENTER AMOUNT TO WITHDRAW FROM WESTERN UNION");
        text.setBounds(130, 60, 400, 25);
        text.setFont(new Font("Arial", Font.BOLD, 14));
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
                    c1.s.executeUpdate("insert into wuwithdrawls values('"+pinnumber+"', '"+date+"', 'WUWithdrawl', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "USD. "+amount+" withdrawn Successfully");
                    setVisible(false);
                    new WUWithdrawl(pinnumber).setVisible(true);
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
        new WUWithdrawl("");
    }
    
}
