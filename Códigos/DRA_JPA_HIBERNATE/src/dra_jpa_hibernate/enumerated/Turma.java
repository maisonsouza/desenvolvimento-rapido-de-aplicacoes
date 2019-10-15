package dra_jpa_hibernate.enumerated;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Turma {
    
    @Id
    @GeneratedValue
    private long id; 

    private String sigla;
    
    @Enumerated(EnumType.STRING)
    private Periodo periodo;
    
    public Turma(String sigla, Periodo periodo) {
        this.sigla = sigla;
        this.periodo = periodo;
    }
    
    
    
}
