package dra_jpa_hibernate.relacionamento.OneToMany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Funcionario_ManyToOne {
    
    @Id @GeneratedValue
    private long id;    
    private String nome;

    public Funcionario_ManyToOne(String nome) {
        this.nome = nome;
    }
    
    
    
}
