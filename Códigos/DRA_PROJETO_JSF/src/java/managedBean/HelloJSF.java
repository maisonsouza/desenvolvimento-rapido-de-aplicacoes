/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class HelloJSF {
    
    private String nome;
    private String mensagem;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getMensagem() {
        return mensagem;
    }
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }  
    
    public void exibeMensagem(){
        mensagem = "Olá, " + this.nome + "!";
    }
    
}
