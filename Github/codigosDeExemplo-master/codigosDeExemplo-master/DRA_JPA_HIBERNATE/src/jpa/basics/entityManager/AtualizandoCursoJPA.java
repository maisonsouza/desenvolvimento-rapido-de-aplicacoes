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
public class AtualizandoCursoJPA {
    public static void main(String args[]){
        EntityManagerFactory factory = 
            Persistence.createEntityManagerFactory("SysControleAcademicoJPA");
        
        EntityManager manager = factory.createEntityManager();
        
        Curso curso = new Curso(1, "TECINFOR", "Técnico em Informática");
        
        manager.merge(curso);
        
        manager.getTransaction().begin();
        manager.getTransaction().commit();
        manager.close();
        
        factory.close();
    }    
}
