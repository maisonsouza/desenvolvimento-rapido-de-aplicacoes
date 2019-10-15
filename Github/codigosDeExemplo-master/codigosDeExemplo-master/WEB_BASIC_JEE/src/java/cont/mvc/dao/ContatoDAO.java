package cont.mvc.dao;

import cont.mvc.bean.Contato;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joyce
 */
public class ContatoDAO {
    
    private Connection connection;
    
    /** estabelece conexao **/
    public ContatoDAO(){
        //connection = ConnectionFactory.getConnection();
    }
    
    /** continua **/
    
    /** recebe conexão **/
    public ContatoDAO(Connection connection){
        this.connection = connection;
    }
       
    public boolean addContato(Contato contato){
        //simulando sucesso de inserção no BD
         return true;
         
        /*
        public boolean adicionaTarefa(Tarefa tarefa){
       String sql = "insert into tarefas " +
                    "(id,descricao,finalizado,dataFinalizacao)" +
                    " values (?,?,?,?)";
       try ( 
        // prepared statement para inserção
        PreparedStatement stmt = connection.prepareStatement(sql)) {
        // seta os valores
        stmt.setLong(1,tarefa.getId());
        stmt.setString(2,tarefa.getDescricao());
        stmt.setBoolean(3,tarefa.isFinalizado());
        stmt.setDate(4, new Date(tarefa.getDataFinalizacao().getTimeInMillis()));
        // executa
        stmt.execute();
       } catch (SQLException e) {
         throw new RuntimeException(e);
       }
       return true;
    }
        */
        
        
       
    }
    
    public List<Contato> getListaContatos(){
        //simulando consulta ao BD
        List<Contato> lista = new ArrayList<Contato>();
        lista.add(new Contato(0, "João", "joao@email", "AM"));
        lista.add(new Contato(0, "Ruth", "ruth@email", "RJ"));
        lista.add(new Contato(0, "Sara", "sara@email", "SP"));
        return lista;
    }    
}
