/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Echo data
 */
public class DBconnect {
    
    private static Connection con;
    
    private DBconnect(){}
    
    public static Connection connect() throws ClassNotFoundException{

        if(con == null){
            Class.forName("com.mysql.jdbc.Driver");
            try{
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/info","root","");
                System.out.println("Connection Successfull");
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
        else{
            System.out.println("You already have a Connection.");
        }
        return con;
    }
}
