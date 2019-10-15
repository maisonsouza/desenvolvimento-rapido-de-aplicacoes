package dra_jpa_hibernate.relacionamento.ManyToMany;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Autor {

    @Id @GeneratedValue
    private long id;    
    
    private String nome;
    
    @ManyToMany(mappedBy = "autores")
    private Collection<Livro> livros;

    public Autor(){}

    public Autor(String nome) {
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

    public Collection<Livro> getLivros() {
        return livros;
    }

    public void setLivros(Collection<Livro> livros) {
        this.livros = livros;
    }

   
    
    
    
}
