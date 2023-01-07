package bank.management.system;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    public Conn() {
        try {
            //Class.forName(com.mysql.cj.jdbc.driver);
            //the last parameter is the password
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Allosparakletos1992.");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
