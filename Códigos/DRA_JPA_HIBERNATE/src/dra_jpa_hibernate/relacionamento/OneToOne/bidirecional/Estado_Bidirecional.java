package dra_jpa_hibernate.relacionamento.OneToOne.bidirecional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Estado_Bidirecional {

    @Id @GeneratedValue
    private long id;    
    private String nome;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    private Governador_Bidirecional governador;
    
    
    public Estado_Bidirecional(){}

    public Estado_Bidirecional(String nome, Governador_Bidirecional governador) {
        this.nome = nome;
        this.governador = governador;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Governador_Bidirecional getGovernador() {
        return governador;
    }

    public void setGovernador(Governador_Bidirecional governador) {
        this.governador = governador;
    }
    
    
    
}
