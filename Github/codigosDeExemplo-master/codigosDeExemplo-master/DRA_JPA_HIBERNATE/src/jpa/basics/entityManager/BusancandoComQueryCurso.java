/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.basics.entityManager;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import jpa.basics.model.Curso;

/**
 *
 * @author Jhoyce
 */
public class BusancandoComQueryCurso {
    public static void main(String args[]){
        EntityManagerFactory factory = 
            Persistence.createEntityManagerFactory("SysControleAcademicoJPA");
        
        EntityManager manager = factory.createEntityManager();
        
        Query query = manager.createQuery("select c from Curso as c "
                                        + "where c.sigla LIKE :param "
                                        + "order by c.sigla ");
        query.setParameter("param", "%TEC%");
        
        List<Curso> listaCursos = query.getResultList();
        
        for (Curso listaCurso : listaCursos) {
            System.out.println("-" + listaCurso.getDescricao());
        }
        
        manager.close();
        
        factory.close();
    }    
}
