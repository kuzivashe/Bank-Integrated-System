
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Transactions extends JFrame implements ActionListener{
    JLabel label1, label2, label3;
    JButton western, mukuru, world, payb, deposit, withdraw, checkb, exit;
    String pinnumber;
    public Transactions(String pinnumber) {
        this.pinnumber = pinnumber;
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
        
        western = new JButton("Western Union");
        western.setBackground(Color.DARK_GRAY);
        western.setForeground(Color.WHITE);
        western.setBounds(90, 50, 130, 30);
        western.addActionListener(this);
        label3.add(western);
        
        mukuru = new JButton("Mukuru");
        mukuru.setBackground(Color.DARK_GRAY);
        mukuru.setForeground(Color.WHITE);
        mukuru.setBounds(90, 100, 130, 30);
        mukuru.addActionListener(this);
        label3.add(mukuru);
        
        world = new JButton("World Remit");
        world.setBackground(Color.DARK_GRAY);
        world.setForeground(Color.WHITE);
        world.setBounds(90, 150, 130, 30);
        world.addActionListener(this);
        label3.add(world);
        
        payb = new JButton("Pay Bills");
        payb.setBackground(Color.DARK_GRAY);
        payb.setForeground(Color.WHITE);
        payb.setBounds(90, 200, 130, 30);
        payb.addActionListener(this);
        label3.add(payb);
        
        deposit = new JButton("Deposit");
        deposit.setBackground(Color.DARK_GRAY);
        deposit.setForeground(Color.WHITE);
        deposit.setBounds(430, 50, 130, 30);
        deposit.addActionListener(this);
        label3.add(deposit);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBackground(Color.DARK_GRAY);
        withdraw.setForeground(Color.WHITE);
        withdraw.setBounds(430, 100, 130, 30);
        withdraw.addActionListener(this);
        label3.add(withdraw);
        
        checkb = new JButton("Check balance");
        checkb.setBackground(Color.DARK_GRAY);
        checkb.setForeground(Color.WHITE);
        checkb.setBounds(430, 150, 130, 30);
        checkb.addActionListener(this);
        label3.add(checkb);
        
        exit = new JButton("Exit");
        exit.setBackground(Color.DARK_GRAY);
        exit.setForeground(Color.WHITE);
        exit.setBounds(430, 200, 130, 30);
        exit.addActionListener(this);
        label3.add(exit);
        
        setSize(700, 570);
        setLocation(300, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == western) {
            setVisible(false);
            new WURefNumber(pinnumber).setVisible(true);
        } else if (ae.getSource() == exit) {
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (ae.getSource() == withdraw) {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        } else if (ae.getSource() == world) {
            setVisible(false);
            new WRRefNumber(pinnumber).setVisible(true);
        } else if (ae.getSource() == mukuru) {
            setVisible(false);
            new MKRefNumber(pinnumber).setVisible(true);
        } else if (ae.getSource() == checkb) {
            setVisible(false);
            new CheckBalance(pinnumber).setVisible(true);
        } else if (ae.getSource() == payb) {
            setVisible(false);
            new PayBills(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Transactions("");
    }
}
