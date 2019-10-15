/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexaoBD.connection;

import java.sql.*;

public class FabricaConexao {
    
   public static Connection getConnection(){
       try{
           String host = "jdbc:mysql://localhost/sysControleAcademico";
           String user = "root";
           String password = "";
           return DriverManager.getConnection(
                   host, user, password);
           
       }catch(SQLException e){
           throw new RuntimeException(e);
       } 
   }
}
