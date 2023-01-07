
package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;


public class WURefNumber extends JFrame implements ActionListener {
    
    String refno = "1234";
    JTextField ref = null;
    String pinnumber;
    JButton enter, back;
    
    WURefNumber(String pinnumber) {
        this.pinnumber = pinnumber;
        setTitle("Western Union Reference Number Page");
        setLayout(null);
        
        JLabel text = new JLabel("Enter Reference number below");
        text.setBounds(85, 120, 200, 25);
        text.setFont(new Font("Raleway", Font.BOLD, 12));
        add(text);
        
        ref = new JTextField();
        ref.setBounds(85, 150, 235, 30);
        add(ref);
        
        enter = new JButton("Enter");
        enter.setBounds(85, 200, 100, 30);
        enter.setFont(new Font("Raleway", Font.BOLD, 12));
        enter.setBackground(Color.blue);
        enter.setForeground(Color.white);
        enter.addActionListener(this);
        add(enter);
        
        back = new JButton("Back");
        back.setBounds(220, 200, 100, 30);
        back.setFont(new Font("Raleway", Font.BOLD, 12));
        back.setBackground(Color.red);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        setSize(400, 400);
        setLocation(300, 0);
        setVisible(true);
        
        getContentPane().setBackground(Color.WHITE);
    }
    public void actionPerformed(ActionEvent ae) {
        try{        
            if(ae.getSource() == enter){
                Conn c1 = new Conn();
                //String cardno  = cardnoTextField.getText();
                String refno  = ref.getText();
                String q  = "select * from refnumber where refno = '"+refno+"'";

                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()){
                    setVisible(false);
                    new WUWithdrawl(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect reference number");
                }
            }else if(ae.getSource() == back){
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new WURefNumber("");
    }
}
