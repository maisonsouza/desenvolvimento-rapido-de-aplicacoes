/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.sql.DataSource;
import mvc.bean.Tarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TarefaDAO {
    
    private final Connection connection;
    
    @Autowired
    public TarefaDAO(DataSource dataSource){
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public boolean adicionaTarefa(Tarefa tarefa){
       String sql = "insert into tarefas (descricao) values (?)";
       try ( 
        // prepared statement para inserção
        PreparedStatement stmt = connection.prepareStatement(sql)) {
        // seta os valores
        stmt.setString(1,tarefa.getDescricao());
        // executa
        stmt.execute();
       } catch (SQLException e) {
         throw new RuntimeException(e);
       }
       return true;
    }    
    
    public List<Tarefa> listarTarefas(){
       List<Tarefa> listaTarefas = new ArrayList<Tarefa>();
       String sql = "select * from tarefas order by descricao";
       try ( 
        PreparedStatement stmt = connection.prepareStatement(sql)) {
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
           Tarefa tarefa = new Tarefa();
           tarefa.setId(rs.getLong("id"));
           tarefa.setDescricao(rs.getString("descricao"));
           tarefa.setFinalizado(rs.getBoolean("finalizado"));
           //montando data
           Calendar data = Calendar.getInstance();
           if(rs.getDate("dataFinalizacao") != null)
           {
               data.setTime(rs.getDate("dataFinalizacao"));
               tarefa.setDataFinalizacao(data);
           }        
           listaTarefas.add(tarefa);               
        }
       } catch (SQLException e) {
         throw new RuntimeException(e);
       }
       return listaTarefas;
    }
    
    public Tarefa buscarTarefaPorId(Long id){
       String sql = "select * from tarefas where id = ? ";
       try ( 
        PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setLong(1,id);
        ResultSet rs = stmt.executeQuery();
        Tarefa tarefa = new Tarefa();
        if(rs.next()) {
           tarefa.setId(rs.getLong("id"));
           tarefa.setDescricao(rs.getString("descricao"));
           tarefa.setFinalizado(rs.getBoolean("finalizado"));
           //montando data
           Calendar data = Calendar.getInstance();
           if(rs.getDate("dataFinalizacao") != null)
           {
               data.setTime(rs.getDate("dataFinalizacao"));
               System.out.println("data");
               tarefa.setDataFinalizacao(data);
           }                 
        }
        return tarefa;
       } catch (SQLException e) {
         throw new RuntimeException(e);
       }
    }
    
    public boolean removerTarefa(Long id){
       String sql = "delete from tarefas where id = ? ";
       try ( 
        PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setLong(1,id);
        stmt.execute();
       } catch (SQLException e) {
         throw new RuntimeException(e);
       }
       return true;
    }
    
    public boolean alterarTarefa(Tarefa tarefa){
       String sql = "update tarefas set descricao = ?,"
                  + " finalizado=?, dataFinalizacao=? where id = ? ";
       try ( 
        PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setString(1,tarefa.getDescricao());
        stmt.setBoolean(2,tarefa.isFinalizado());
        if(tarefa.getDataFinalizacao() != null){
            stmt.setDate(3, new Date(tarefa.getDataFinalizacao().getTimeInMillis()));
        }else{
            stmt.setNull(3, java.sql.Types.DATE);
        }
        stmt.setLong(4,tarefa.getId());
        stmt.execute();
       } catch (SQLException e) {
         throw new RuntimeException(e);
       }
       return true;
    }
    
    public boolean finalizarTarefa(Long id){
       String sql = " update tarefas set finalizado=true, "
               +    " dataFinalizacao=now() where id = ? ";
       try { 
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, id);
        stmt.execute();
       } catch (SQLException e) {
         throw new RuntimeException(e);
       }
       return true;
    }
    
    
}
