/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DBConnection {
     private static Connection conn;
    static
    {
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-80CC33A:1521/XE","onlineexam","java");
            JOptionPane.showMessageDialog(null,"connected successfully to DB");
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Cannot connect to DB"+e,"Error",JOptionPane.ERROR_MESSAGE);
            System.out.println("Error is"+e);
        }
    }
            public static Connection getConnection()
    {
        return conn;
    }
    public static void closeConnection()
    {
        try{
            

        conn.close(); 
          JOptionPane.showMessageDialog(null,"Disconnected successfully to DB","Success",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"Cannot connect to DB");
            ex.printStackTrace();
        }
    }
}
