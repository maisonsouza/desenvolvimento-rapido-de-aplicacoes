package jpa.basics.daogenerico;

import jpa.basics.connectionfactory.ConnectionFactory;
import jpa.basics.model.Curso;

public class TesteGenericDAO {
    public static void main(String[] args) {
        
        GenericDAO<Curso> cursoDAO = new GenericDAO<>
                                         (ConnectionFactory.getEntityManager());
        
        Curso curso = new Curso("TECQUIM", "TÉCNICO EM QUÍMICA");
        
        cursoDAO.save(curso);
        
        ConnectionFactory.closeEntityFactory();
        
        
    }
}
