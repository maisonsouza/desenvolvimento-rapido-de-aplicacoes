package cont.jsp.dao;

import cont.servlets.bean.Contato;
import java.util.ArrayList;
import java.util.List;


public class ContatoDAO {
        
    /** estabelece conexão com BD */
    public ContatoDAO() {
        //codigo para carregar conexao com BD
    }
       
    public boolean addContato(Contato contato){
        //simulando sucesso de inserção no BD
        return true;
    } 
    
    public List<Contato> getListaContatos(){
        //simulando consulta ao BD
        List<Contato> listaContatos = new ArrayList<Contato>();
        listaContatos.add(new Contato(0, "João" , "j@email", "RJ"));
        listaContatos.add(new Contato(0, "Maria", "m@email", "AM"));
        return listaContatos;
    }
    
}
