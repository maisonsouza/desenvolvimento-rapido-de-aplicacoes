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
public class BuscandoPorIDCurso {
    public static void main(String args[]){
        EntityManagerFactory factory = 
            Persistence.createEntityManagerFactory("SysControleAcademicoJPA");
        
        EntityManager manager = factory.createEntityManager();
        
        Curso curso = manager.find(Curso.class, 1L);
        
        System.out.println("Curso: " + curso.getSigla() 
                                     + " - " + curso.getDescricao() );
        
        manager.close();
        
        factory.close();
    }    
}
