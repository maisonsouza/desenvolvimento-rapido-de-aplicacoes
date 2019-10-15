package dra_jpa_hibernate.entity;

import java.util.Calendar;
import jpa.basics.daogenerico.*;
import jpa.basics.connectionfactory.ConnectionFactory;

public class TesteGenericDAO {
    public static void main(String[] args) {
        
        /*Pessoa*/
        GenericDAO<Pessoa> pessoaDAO = 
                new GenericDAO<>
                    (ConnectionFactory.getEntityManager());
        
        Calendar nascimento = Calendar.getInstance();
        nascimento.set(2018, 9, 3);
        
        Pessoa pessoa = new Pessoa("Fulano", nascimento);
        pessoaDAO.save(pessoa);
        
        ConnectionFactory.closeEntityFactory();
        
        
    }
}
