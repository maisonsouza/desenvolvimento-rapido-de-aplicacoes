package dra_jpa_hibernate.relacionamento.ManyToMany;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Livro {
    
    @Id @GeneratedValue
    private long id;    
    private String nome;
    
    @ManyToMany
    @JoinTable(name = "liv_aut",
            joinColumns = @JoinColumn(name="liv_id"),
            inverseJoinColumns = @JoinColumn(name="aut_id"))
    private Collection<Autor> autores;

    public Livro(){}

    public Livro(String nome, Collection<Autor> autores) {
        this.nome = nome;
        this.autores = autores;
    }

    
    
    public Livro(String nome) {
        this.nome = nome;
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

    public Collection<Autor> getAutores() {
        return autores;
    }

    public void setAutores(Collection<Autor> autores) {
        this.autores = autores;
    }

    
   
    
    
}
