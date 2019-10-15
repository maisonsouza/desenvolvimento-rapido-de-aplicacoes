package dra_jpa_hibernate.relacionamento.OneToOne.cascade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Governador_Cascade {
    
    @Id @GeneratedValue
    private long id;    
    private String nome;

    public Governador_Cascade(String nome) {
        this.nome = nome;
    }
    
    
    
}
