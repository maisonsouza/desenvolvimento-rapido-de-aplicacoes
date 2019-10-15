package dra_jpa_hibernate.relacionamento.OneToMany;

import java.util.ArrayList;
import java.util.Collection;
import jpa.basics.daogenerico.*;
import jpa.basics.connectionfactory.ConnectionFactory;

public class TesteGenericDAO {
    public static void main(String[] args) {
        
        GenericDAO<Departamento> deptoDAO = 
                new GenericDAO<>
                    (ConnectionFactory.getEntityManager());
        
        Collection<Funcionario_ManyToOne> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario_ManyToOne("Fulano"));
        funcionarios.add(new Funcionario_ManyToOne("Beltrano"));
        funcionarios.add(new Funcionario_ManyToOne("Ciclano"));
        
        Departamento depto = new Departamento("DAIC", funcionarios);
        deptoDAO.save(depto);
        
        ConnectionFactory.closeEntityFactory();
        
        
    }
}
