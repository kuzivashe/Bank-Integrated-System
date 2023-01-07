
package bank.management.system;

import java.awt.*;
import java.util.*;
//import java.awt.Image;
//import java.awt.event.ActionEvent;
import java.awt.event.*;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JCheckBox;
//import javax.swing.JFrame;
import javax.swing.*;


public class Signuptwo extends JFrame implements ActionListener {
    String formno;
    JLabel label1, label2, label3, label4, label6, label7, label8, label9, label10;
    JButton button1, button2;
    JCheckBox check;
    
    Signuptwo(String formno) {
        this.formno = formno;
        setTitle("New Account Application Form - Card No and Pin");
        setLayout(null);
        
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("images/cbz-holdings-logo.jpg"));
        Image img1 = icon1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        Image img2 = icon2.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(img1);
        ImageIcon icon4 = new ImageIcon(img2);
        label1 = new JLabel(icon3);
        label2 = new JLabel(icon4);
        label1.setBounds(10, 10, 350, 130);
        label2.setBounds(310, 10, 350, 130);
        add(label1);
        add(label2);
        
        setSize(700, 700);
        setLocation(300, 0);
        setVisible(true);
        
        label3 = new JLabel("Card number");
        label3.setFont(new Font("Raleway", Font.BOLD, 18));
        
        label4 = new JLabel("XXXX-XXXX-XXXX-4184");
        label4.setFont(new Font("Raleway", Font.BOLD, 18));
        
        //label5 = new JLabel("Card number");
        //label5.setFont(new Font("Raleway", Font.BOLD, 18));
        
        label6 = new JLabel("Your 16-digit Card number");
        label6.setFont(new Font("Raleway", Font.BOLD, 12));
        
        label7 = new JLabel("PIN: ");
        label7.setFont(new Font("Raleway", Font.BOLD, 18));
        
        label8 = new JLabel("XXXX");
        label8.setFont(new Font("Raleway", Font.BOLD, 18));
        
        label9 = new JLabel("4-digit pin code");
        label9.setFont(new Font("Raleway", Font.BOLD, 12));
        
        label10 = new JLabel("form no");
        label10.setFont(new Font("Raleway", Font.BOLD, 14));
        
        button1 = new JButton("CONTINUE");
        button1.setFont(new Font("Raleway", Font.BOLD, 14));
        button1.setBackground(Color.BLUE);
        button1.setForeground(Color.WHITE);
        add(button1);
        
        button2 = new JButton("CANCEL");
        button2.setFont(new Font("Raleway", Font.BOLD, 14));
        button2.setBackground(Color.RED);
        button2.setForeground(Color.WHITE);
        add(button2);
        
        check = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
        check.setBackground(Color.WHITE);
        check.setFont(new Font("Raleway", Font.BOLD, 10));
        check.setBounds(100,420,500,20);
        add(check);
        
        label3.setBounds(100,300,200,30);
        add(label3);
        
        label4.setBounds(330,300,250,30);
        add(label4);
        
        label6.setBounds(100,320,200,30);
        add(label6);
        
        label7.setBounds(100,350,200,30);
        add(label7);
        
        label8.setBounds(330,350,250,30);
        add(label8);
        
        label9.setBounds(100,370,200,30);
        add(label9);
        
        button1.setBounds(100, 500, 200, 30);
        button2.setBounds(400, 500, 200, 30);
        
        button1.addActionListener(this);
        button2.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        
    }
    public void actionPerformed(ActionEvent ae) {
        //String atype = null;
       /* if (ae.getSource() == button1) {
            setVisible(false);
            new Transactions().setVisible(true);
        }*/
        
        
        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
        String cardno = "" + Math.abs(first7);
        
        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);
        
        try{
            if(ae.getSource() == button1){
                
               /*if(atype.equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                }else{*/
                    Conn c1 = new Conn();
                    String q1 = "insert into signuptwo values('"+formno+"', '"+cardno+"','"+pin+"')";  
                    String q2 = "insert into login values('"+formno+"','"+cardno+"','"+pin+"')";
                    c1.s.executeUpdate(q1);
                    c1.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\n Pin:"+ pin);
                    
                    new Deposit(pin).setVisible(true);
                    setVisible(false);
                //}
            
            }else if (ae.getSource() == button2) {
                setVisible(false);
                new Login().setVisible(true);
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        //setVisible(false);
        new Signuptwo("").setVisible(true);
    }

    
}
