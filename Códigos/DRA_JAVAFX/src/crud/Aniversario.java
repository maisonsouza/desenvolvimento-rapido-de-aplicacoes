package crud;

import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Aniversario {

    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty nome = new SimpleStringProperty();
    private final ObjectProperty<LocalDate> dataAniversario = new SimpleObjectProperty<>();

    public Aniversario(int id, String nome, LocalDate dataAniversario) {
        this.id.set(id);
        this.nome.set(nome);
        this.dataAniversario.set(dataAniversario);
    }
    
    public LocalDate getDataAniversario() {
        return dataAniversario.get();
    }

    public void setDataAniversario(LocalDate value) {
        dataAniversario.set(value);
    }

    public ObjectProperty dataAniversarioProperty() {
        return dataAniversario;
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

    
    
    
    public int getId() {
        return id.get();
    }

    public void setId(int value) {
        id.set(value);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    
    

    
    
    
}
