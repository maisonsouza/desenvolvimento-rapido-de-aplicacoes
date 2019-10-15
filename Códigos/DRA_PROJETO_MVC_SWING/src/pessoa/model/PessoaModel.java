package pessoa.model;

import java.time.LocalDate;

public class PessoaModel {

    private LocalDate dataNascimento;
    
    public void setDataNascimento(LocalDate dataNascimento){
        this.dataNascimento =  dataNascimento;
    }
    
    public LocalDate getDataNascimento(){
        return dataNascimento;
    }
    
    public int calcIdade(int anoAtual){
        int idade = anoAtual - dataNascimento.getYear();
        return idade;
    }

}
