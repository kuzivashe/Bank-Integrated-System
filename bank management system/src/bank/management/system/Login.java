package bank.management.system;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

//remember to extend JFrame and implement ActionListener so that frame is useable
//and buttons can be actionable
public class Login extends JFrame implements ActionListener{
    //you have to declare these global variables because you used them outside
    //the login()
    JLabel l1, cardno, pin;
    JTextField cardnoTextField;
    JPasswordField pinTextField;
    JButton signin, clear, signup;
  
    Login(){
        setTitle("CBZ Integrated System ATM");
        
        //url of images start at images not before because both package and images are in the
        //same source file
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        //the image has to be put on a label
        JLabel l11 = new JLabel(i3);
        //bounds(int x, int y, height, width)
        l11.setBounds(70, 10, 100, 100);
        add(l11);
        
        l1 = new JLabel("WELCOME TO CBZ ATM");
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        l1.setBounds(200,40,450,40);
        add(l1);
        
        cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(125,150,375,30);
        add(cardno);
        
        cardnoTextField = new JTextField(15);
        cardnoTextField.setBounds(300,150,230,30);
        cardnoTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardnoTextField);
        
        pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(125,220,375,30);
        add(pin);
        
        pinTextField = new JPasswordField(15);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        pinTextField.setBounds(300,220,230,30);
        add(pinTextField);
                
        signin = new JButton("SIGN IN");
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        
        clear = new JButton("CLEAR");
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        
        signup = new JButton("SIGN UP");
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        
        setLayout(null);
        
        signin.setFont(new Font("Arial", Font.BOLD, 14));
        signin.setBounds(300,300,100,30);
        add(signin);
        
        clear.setFont(new Font("Arial", Font.BOLD, 14));
        clear.setBounds(430,300,100,30);
        add(clear);
        
        signup.setFont(new Font("Arial", Font.BOLD, 14));
        signup.setBounds(300,350,230,30);
        add(signup);
        
        signin.addActionListener(this);
        clear.addActionListener(this);
        signup.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,480);
        setLocation(550,200);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        try{        
            if(ae.getSource() == signin){
                Conn c1 = new Conn();
                String cardno  = cardnoTextField.getText();
                String pin  = pinTextField.getText();
                String q  = "select * from login where cardno = '"+cardno+"' and pin = '"+pin+"'";

                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }else if(ae.getSource() == clear){
                cardnoTextField.setText("");
                pinTextField.setText("");
            }else if(ae.getSource() == signup){
                setVisible(false);
                new Signup().setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Login();
    }
}