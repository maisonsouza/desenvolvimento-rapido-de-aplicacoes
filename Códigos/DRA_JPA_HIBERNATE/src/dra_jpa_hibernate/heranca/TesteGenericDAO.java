package dra_jpa_hibernate.heranca;

import dra_jpa_hibernate.entity.*;
import java.util.Calendar;
import jpa.basics.daogenerico.*;
import jpa.basics.connectionfactory.ConnectionFactory;

public class TesteGenericDAO {
    public static void main(String[] args) {
        
        /*Pessoa*/
        GenericDAO<Pessoa_Fisica> pessoaDAO = 
                new GenericDAO<>
                    (ConnectionFactory.getEntityManager());
        
        Pessoa_Fisica pessoa1 = new Pessoa_Fisica("Fulano", "123456");
        pessoaDAO.save(pessoa1);
        
        Pessoa_Fisica pessoa2 = new Pessoa_Fisica("Ciclano", "654321");
        pessoaDAO.save(pessoa2);
        
        ConnectionFactory.closeEntityFactory();
        
        
    }
}
