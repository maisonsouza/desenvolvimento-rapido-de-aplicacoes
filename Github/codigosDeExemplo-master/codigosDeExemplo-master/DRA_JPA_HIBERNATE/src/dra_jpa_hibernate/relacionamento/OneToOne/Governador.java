package dra_jpa_hibernate.relacionamento.OneToOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Governador {
    
    @Id @GeneratedValue
    private long id;    
    private String nome;

    public Governador(String nome) {
        this.nome = nome;
    }
    
    
    
}
