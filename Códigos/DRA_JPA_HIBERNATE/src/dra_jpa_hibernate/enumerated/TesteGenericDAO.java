package dra_jpa_hibernate.enumerated;

import dra_jpa_hibernate.entity.Pessoa;
import java.util.Calendar;
import jpa.basics.daogenerico.*;
import jpa.basics.connectionfactory.ConnectionFactory;

public class TesteGenericDAO {
    public static void main(String[] args) {
        
        /*Turma*/
        GenericDAO<Turma> pessoaDAO = 
                new GenericDAO<>
                    (ConnectionFactory.getEntityManager());
        
        Turma turma = new Turma("TADS", Periodo.VESPERTINO);
        pessoaDAO.save(turma);
        
        ConnectionFactory.closeEntityFactory();
        
        
    }
}
