package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import modelo.Usuario;

public class UsuarioDAO {

    private final EntityManager entityManager ;  //Um atributo final de uma classe pode ter seu valor atribuído uma única vez, seja na própria declaração ou no construtor. 
    
    public UsuarioDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    public boolean validaSenha(Usuario usuario){
        //monta consulta        
        TypedQuery<Long> query = entityManager.createQuery("select count(u) from Usuario as u "
                                        + "where u.login = :login "
                                        + "  and u.senha = :senha ", Long.class);
        query.setParameter("login", usuario.getLogin());
        query.setParameter("senha", usuario.getSenha());
        Long quantidade = query.getSingleResult();
        return quantidade > 0;
    }
    
    public List<Usuario> listaUsuarios(){
        Query query = entityManager.createNamedQuery("Usuario.findAll");
        return query.getResultList();
    }
    
    public Usuario save(Usuario usuario) {
    try {
      System.out.println("Salvando um usuário.");
      // Inicia uma transação com o banco de dados.
      entityManager.getTransaction().begin();
      // Insere objeto no BD.
      entityManager.persist(usuario);
      // Sincroniza transação.
      entityManager.getTransaction().commit();
    } catch(Exception e){
      entityManager.getTransaction().rollback();
      return null;
    }
    return usuario;
  }
    
  
  
}