package dra_jpa_hibernate.relacionamento.OneToOne.objetosEmbutidos;

import java.util.Calendar;
import jpa.basics.daogenerico.*;
import jpa.basics.connectionfactory.ConnectionFactory;

public class TesteGenericDAO {
    public static void main(String[] args) {
        
        GenericDAO<Pessoa_ObjetoEmbutido> pessoaDAO = 
                new GenericDAO<>
                    (ConnectionFactory.getEntityManager());
        
        Calendar nascimento = Calendar.getInstance();
        nascimento.set(2018, 9, 3);
        
        Endereco endereco = 
            new Endereco("Brasil", "Amazonas", "Manaus", "Centro", "123");
        
        Pessoa_ObjetoEmbutido pessoa = new Pessoa_ObjetoEmbutido("Fulano", nascimento, endereco);
        pessoaDAO.save(pessoa);
        
        ConnectionFactory.closeEntityFactory();
        
        
    }
}
