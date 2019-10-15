/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dra_jpa_hibernate.relacionamento.OneToOne.objetosEmbutidos;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="pessoa")
public class Pessoa_ObjetoEmbutido {
    
    @Id
    @GeneratedValue
    @Column(name="col_id")
    private long id;
    
    @Column(length = 30, nullable = false, unique = true)
    private String nome;
    
    @Temporal(TemporalType.DATE)
    private Calendar nascimento;
    
    @Lob
    private byte[] foto;
    
    @Transient
    private int idade;
    
    private Endereco endereco;

    public Pessoa_ObjetoEmbutido(String nome, Calendar nascimento, Endereco endereco) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.endereco = endereco;
    }
    
    
    
    }
