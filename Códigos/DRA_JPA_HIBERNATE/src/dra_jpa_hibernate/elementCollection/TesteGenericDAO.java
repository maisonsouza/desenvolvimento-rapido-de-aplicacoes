package dra_jpa_hibernate.elementCollection;

import java.util.ArrayList;
import java.util.List;
import jpa.basics.daogenerico.*;
import jpa.basics.connectionfactory.ConnectionFactory;

public class TesteGenericDAO {
    public static void main(String[] args) {
        
        GenericDAO<Funcionario> pessoaDAO = 
                new GenericDAO<>
                    (ConnectionFactory.getEntityManager());
        
        List<String> telefones = new ArrayList<>();
        
        telefones.add("1111-1111");
        telefones.add("2222-2222");
        
        Funcionario funcionario = new Funcionario("Fulano", telefones);
        pessoaDAO.save(funcionario);
        
        ConnectionFactory.closeEntityFactory();
        
        
    }
}
