/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import mvc.bean.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Joyce
 */

@Repository
public class UsuarioDAO {
    
    private final Connection connection;
    
    @Autowired
    public UsuarioDAO(DataSource dataSource){
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public boolean validaUsuario(Usuario user){
       String sql = "select * from usuarios where login = ? and senha = ? ";
       try ( 
        PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setString(1,user.getLogin());
        stmt.setString(2,user.getSenha());
        ResultSet rs = stmt.executeQuery();
        if(rs.next()) {
          return true;        
        }else{
            return false;
        }
       } catch (SQLException e) {
         throw new RuntimeException(e);
       }
    }
    
    public boolean adicionaUsuario(Usuario usuario){
       String sql = "insert into usuarios (login, senha, photo) values (?,?,?)";
       try ( 
        // prepared statement para inserção
        PreparedStatement stmt = connection.prepareStatement(sql)) {
        // seta os valores
        stmt.setString(1,usuario.getLogin());
        stmt.setString(2,usuario.getSenha());
        stmt.setString(3,usuario.getPhoto());
        // executa
        stmt.execute();
       } catch (SQLException e) {
         throw new RuntimeException(e);
       }
       return true;
    }  
    
    public List<Usuario> listarUsuarios(){
       List<Usuario> listaUsuarios = new ArrayList<Usuario>();
       String sql = "select * from usuarios order by login";
       try ( 
        PreparedStatement stmt = connection.prepareStatement(sql)) {
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
           Usuario usuario = new Usuario();
           
           usuario.setId(rs.getInt("id"));
           usuario.setLogin(rs.getString("login"));
           usuario.setSenha(rs.getString("senha"));
           usuario.setPhoto(rs.getString("photo"));
           
           listaUsuarios.add(usuario);               
        }
       } catch (SQLException e) {
         throw new RuntimeException(e);
       }
       return listaUsuarios;
    }
    
    
}
