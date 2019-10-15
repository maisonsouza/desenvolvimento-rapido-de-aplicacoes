/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cont.mvc.connection;

import java.sql.*;

public class ConnectionFactory {
    
   public static Connection getConnection(){
       try{
           Class.forName("com.mysql.jdbc.Driver");  
           String host = "jdbc:mysql://localhost/sysControleAcademico";
           String user = "root";
           String password = "";
           return DriverManager.getConnection(
                   host, user, password);
           
       }catch(Exception e){
           throw new RuntimeException(e);
       } 
   }
}
