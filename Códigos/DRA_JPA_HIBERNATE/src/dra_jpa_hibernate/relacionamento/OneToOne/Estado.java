package dra_jpa_hibernate.relacionamento.OneToOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Estado {

    @Id @GeneratedValue
    private long id;    
    private String nome;
    
    @OneToOne
    @JoinColumn(name="gov_id")
    private Governador governador;

    public Estado(String nome, Governador governador) {
        this.nome = nome;
        this.governador = governador;
    }
    
    
    
}
