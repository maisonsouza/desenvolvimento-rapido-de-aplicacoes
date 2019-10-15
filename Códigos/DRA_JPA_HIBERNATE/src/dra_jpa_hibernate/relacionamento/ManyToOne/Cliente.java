package dra_jpa_hibernate.relacionamento.ManyToOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cliente {
    
    @Id @GeneratedValue
    private long id;    
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }
    
    
    
}
