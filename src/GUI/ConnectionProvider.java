/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Utilizador
 */
public class ConnectionProvider {
    
          public static Connection  Connector(){
        try{
            Class.forName("org.sqlite.JDBC");
            Connection con= DriverManager.getConnection("jdbc:sqlite:cafe.db");
            return con;
        }catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
            return null;
        }
    }
    
}
