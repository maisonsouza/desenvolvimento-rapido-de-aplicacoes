package dra_jpa_hibernate.relacionamento.OneToOne;

import jpa.basics.daogenerico.*;
import jpa.basics.connectionfactory.ConnectionFactory;

public class TesteGenericDAO {
    public static void main(String[] args) {
        
        GenericDAO<Governador> governadorDAO = 
                new GenericDAO<>
                    (ConnectionFactory.getEntityManager());
        
        Governador governador = new Governador("Fulaninho");
        governadorDAO.save(governador);
        
        GenericDAO<Estado> pessoaDAO = 
                new GenericDAO<>
                    (ConnectionFactory.getEntityManager());
        
        Estado estado = 
                new Estado("Amazonas", governador);
        pessoaDAO.save(estado);
        
        ConnectionFactory.closeEntityFactory();
        
        
    }
}
