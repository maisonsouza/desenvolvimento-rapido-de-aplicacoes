/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.time.LocalDate;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PessoaProperties {

    private final StringProperty nome = new SimpleStringProperty();
    
    private final ObjectProperty<LocalDate> dataNascimento = new SimpleObjectProperty<>();

    public PessoaProperties(String nome, LocalDate dataNascimento) {
        this.nome.set(nome);
        this.dataNascimento.set(dataNascimento);
    }
    
    public LocalDate getDataNascimento() {
        return dataNascimento.get();
    }

    public void setDataNascimento(LocalDate value) {
        dataNascimento.set(value);
    }

    public ObjectProperty dataNascimentoProperty() {
        return dataNascimento;
    }

    public String getNome() {
        return nome.get();
    }

    public void setNome(String value) {
        nome.set(value);
    }

    public StringProperty nomeProperty() {
        return nome;
    }

   
   
    
}
