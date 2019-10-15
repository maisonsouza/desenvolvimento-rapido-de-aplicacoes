package dra_jpa_hibernate.relacionamento.OneToMany;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Departamento {

    @Id @GeneratedValue
    private long id;     
    private String nome;
    
    @OneToMany(cascade = CascadeType.PERSIST)
    private Collection<Funcionario_ManyToOne> funcionarios;

    public Departamento(String nome, Collection<Funcionario_ManyToOne> funcionarios) {
        this.nome = nome;
        this.funcionarios = funcionarios;
    }
    
}
