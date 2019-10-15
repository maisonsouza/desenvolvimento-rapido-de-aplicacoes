/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceitosOO.heranca;

/**
 *
 * @author Joyce
 */
public class Aluno extends Individuo {
    
    private String matricula;
    private int anoIngresso;

    public Aluno(){}
    
    public Aluno(String matricula, int anoIngresso, String nome, String telefone, String endereco) {
        super(nome, telefone, endereco);
        this.matricula = matricula;
        this.anoIngresso = anoIngresso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getAnoIngresso() {
        return anoIngresso;
    }

    public void setAnoIngresso(int anoIngresso) {
        this.anoIngresso = anoIngresso;
    }
    
        
}
