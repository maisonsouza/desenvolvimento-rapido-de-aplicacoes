/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dra_jpa_hibernate.relacionamento.OneToOne.objetosEmbutidos;

import javax.persistence.Embeddable;


@Embeddable
public class Endereco {
    
    private String pais;
    private String estado;
    private String cidade;
    private String logradouro;
    private String numero;

    public Endereco(String pais, String estado, String cidade, String logradouro, String numero) {
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.numero = numero;
    }
    
    
    
}
