/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dra_jpa_hibernate.heranca;

import javax.persistence.Entity;

@Entity
public class Pessoa_Juridica extends Pessoa_Heranca{
    
    private String cpf;

    public Pessoa_Juridica(String nome, String cpf) {
        super(nome);
        this.cpf = cpf;
    }

}
