/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.basics.entityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpa.basics.model.Curso;

/**
 *
 * @author Jhoyce
 */
public class InserindoCursoJPA {
    public static void main(String args[]){
        EntityManagerFactory factory = 
            Persistence.createEntityManagerFactory("SysControleAcademicoJPA");
        
        EntityManager manager = factory.createEntityManager();
        
        manager.persist(new Curso("TECINFO", "Técnico em Informática"));
        
        manager.getTransaction().begin();
        manager.getTransaction().commit();
        manager.close();
        
        /* aplicando rollback */
        //manager.flush();
        //manager.getTransaction().rollback();
        
        
        factory.close();
    }    
}
