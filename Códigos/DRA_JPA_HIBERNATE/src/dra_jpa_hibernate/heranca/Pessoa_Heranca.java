/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dra_jpa_hibernate.heranca;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa_Heranca {
    
    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String nome;

    public Pessoa_Heranca(String nome) {
        this.nome = nome;
    }
    
    
    
    }
