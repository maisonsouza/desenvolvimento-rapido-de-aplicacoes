package dra_jpa_hibernate.relacionamento.OneToOne.cascade;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Estado_Cascade {

    @Id @GeneratedValue
    private long id;    
    private String nome;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    private Governador_Cascade governador;

    public Estado_Cascade(String nome, Governador_Cascade governador) {
        this.nome = nome;
        this.governador = governador;
    }
    
    
    
}
