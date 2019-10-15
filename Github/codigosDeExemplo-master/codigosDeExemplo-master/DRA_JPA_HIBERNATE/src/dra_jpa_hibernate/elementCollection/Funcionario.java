package dra_jpa_hibernate.elementCollection;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Funcionario implements Serializable {

    @Id @GeneratedValue
    private Long id;
    private String nome ;    
    @ElementCollection
    @Column(name="telefone")
    @CollectionTable(
    name="Telefones_dos_Funcionarios",
    joinColumns=@JoinColumn(name="func_id"))
    private Collection<String > telefones ;

    public Funcionario(String nome, Collection<String> telefones) {
        this.nome = nome;
        this.telefones = telefones;
    }
    
    

}
