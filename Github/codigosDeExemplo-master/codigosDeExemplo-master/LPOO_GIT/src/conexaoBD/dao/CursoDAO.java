/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexaoBD.dao;

import conexaoBD.bean.Curso;
import conexaoBD.connection.FabricaConexao;

import java.sql.*;
import java.util.Vector;

public class CursoDAO {

    private Connection connection;
    
    public CursoDAO() {
        this.connection = FabricaConexao.getConnection(); 
    }
    
    public boolean cadastrar(Curso curso){
        String sql = "INSERT INTO CURSO VALUES (0, ?, ?)";        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, curso.getSigla());
            ps.setString(2, curso.getDescricao());
            ps.execute();
            connection.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } 
    
    public Vector<Curso> consultar(String valorBuscado){
        String sql = "SELECT * FROM CURSO c WHERE c.descricao LIKE ? ";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, '%' + valorBuscado + '%');
            
            ResultSet rs = ps.executeQuery();
            
            Vector listaCursos = new Vector();
            
            while(rs.next()){
                int codigo = rs.getInt("idCurso"); /** nome do campo no BD **/
                String sigla = rs.getString("sigla");  
                String descricao = rs.getString("descricao");  
                Curso curso = new Curso(codigo, sigla, descricao); 
                listaCursos.add(curso);
            }
            ps.close();
            connection.close();
            return listaCursos;
            
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public boolean alterar(Curso curso){
        String sql = "UPDATE CURSO SET sigla=?, descricao=? WHERE idCurso=?";        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, curso.getSigla());
            ps.setString(2, curso.getDescricao());
            ps.setInt(3, curso.getCodigo());
            ps.execute();
            connection.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } 
    
    public boolean excluir(int idCurso){
        String sql = "DELETE FROM CURSO WHERE idCurso=?";        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idCurso);
            ps.execute();
            connection.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } 
    
    
}
