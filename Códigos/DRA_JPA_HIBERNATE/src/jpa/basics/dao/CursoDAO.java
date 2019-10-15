package jpa.basics.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import jpa.basics.model.Curso;

public class CursoDAO {

    private final EntityManager entityManager ;  //Um atributo final de uma classe pode ter seu valor atribuído uma única vez, seja na própria declaração ou no construtor. 
    
    CursoDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
  public Curso save(Curso curso) {
    try {
      System.out.println("Salvando um curso.");
      // Inicia uma transação com o banco de dados.
      entityManager.getTransaction().begin();
      // Insere objeto no BD.
      entityManager.persist(curso);
      // Sincroniza transação.
      entityManager.getTransaction().commit();
    } catch(Exception e){
      entityManager.getTransaction().rollback();
    }
    return curso;
  }
  
  public Curso update(Curso curso) {
    try {
      System.out.println("Atualizando um curso.");
      // Inicia uma transação com o banco de dados.
      entityManager.getTransaction().begin();
      //Atualiza objeto no BD.
      entityManager.merge(curso);
      //Sincroniza transação.
      entityManager.getTransaction().commit();
    } catch(Exception e){
      entityManager.getTransaction().rollback();
    }
    return curso;
  }

  public void remove(Long idCurso) {
    try {
      System.out.println("Excluindo a curso.");
      //Inicia uma transação com o banco de dados.
      entityManager.getTransaction().begin();
      //Consulta curso pelo id 
      Curso curso = this.findById(idCurso);
      // Remove a curso do BD.
      entityManager.remove(curso);      
      // Sincroniza a transação.
      entityManager.getTransaction().commit();    
    } catch(Exception e){
      entityManager.getTransaction().rollback();
    }
  }

  public Curso findById(Long idCurso) {
    Curso curso = null;
    try {
      //Consulta curso pelo id
      curso = entityManager.find(Curso.class, idCurso);
    } catch(Exception e){
      entityManager.getTransaction().rollback();
    }
    return curso;
  }
  
  public List<Curso> findByDescricao(String descricao) {
    List<Curso> listaCursos = null;
    try {
        //monta consulta        
        Query query = entityManager.createQuery("select c from Curso as c "
                                        + "where c.descricao LIKE :param "
                                        + "order by c.descricao ");
        query.setParameter("param", "%"+descricao+"%");
        
        listaCursos = query.getResultList();
        
    } catch(Exception e){
      entityManager.getTransaction().rollback();
    }
    return listaCursos;
  }
  
}