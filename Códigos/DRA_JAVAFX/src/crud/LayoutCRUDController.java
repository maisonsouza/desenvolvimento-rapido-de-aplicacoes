/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javax.swing.JOptionPane;

public class LayoutCRUDController implements Initializable {
    
    @FXML
    private TableView tabelaAniversarios;    
    @FXML
    private TextField txtId;    
    @FXML
    private TextField txtNome;
    @FXML
    private DatePicker txtDataAniversario; 
    @FXML
    private Button btnExcluir;
    @FXML
    private Button btnSalvar;
    @FXML
    private TextField txtAniversarioPesquisado;
    
    ObservableList<Aniversario> observableList;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
        //carrega dados da tabela
        loadTabela();
        
        
        //add listener da observableList
        observableList.addListener(new ObservableListAlterada()); 
        
        //add listener de selecao da tabela
        tabelaAniversarios.getSelectionModel().selectedItemProperty().addListener(
                new AniversarioSelecionadoListener());
        
        //add listener de campo de busca
        txtAniversarioPesquisado.textProperty().addListener(
                                            new ServicoPesquisadoListener());
        
        //binding para habilitar/desabilitar botoes
        btnExcluir.disableProperty().bind(
                tabelaAniversarios.getSelectionModel().selectedItemProperty().isNull());
        btnSalvar.disableProperty().bind(
                txtNome.textProperty().isEmpty().
                or(txtDataAniversario.valueProperty().isNull()));
        
    
    }    
   
    
    class ObservableListAlterada implements ListChangeListener{
        @Override
        public void onChanged(Change c) {
            //toda vez que a observablelist for alterada
            //a tabela é atualizada
            tabelaAniversarios.setItems(c.getList());
        }
    }
    
    
    class AniversarioSelecionadoListener implements ChangeListener<Aniversario>{
        @Override
        public void changed(ObservableValue<? extends Aniversario> observable, 
                Aniversario oldValue, Aniversario newValue) {
                        //definindo binding
            if (oldValue !=null) {
                txtId.textProperty().unbindBidirectional(
                        oldValue.idProperty());
                txtNome.textProperty().unbindBidirectional(
                        oldValue.nomeProperty());
                txtDataAniversario.valueProperty().unbindBidirectional(
                        oldValue.dataAniversarioProperty());
            }
            if (newValue !=null){
                txtId.textProperty().bindBidirectional(
                        newValue.idProperty(), NumberFormat.getNumberInstance());
                txtNome.textProperty().bindBidirectional(
                        newValue.nomeProperty());
                txtDataAniversario.valueProperty().bindBidirectional(
                        newValue.dataAniversarioProperty());
                
            }
        }
        
    }

    
    
    class NumeroFormatter extends StringConverter<Double>{
        DecimalFormat formatter = new DecimalFormat(".00");

        @Override
        public String toString(Double object) {
            return formatter.format(object);
        }

        @Override
        public Double fromString(String string) {
            return Double.valueOf(string);
        }

        
    }

            
    class ServicoPesquisadoListener implements ChangeListener<String>{
        @Override
        public void changed(ObservableValue<? extends String> observable, 
                            String oldValue, String newValue) {
            
            //criando filtro
            FilteredList<Aniversario> filteredData = new FilteredList(observableList);
            
            //definindo criterio do filtro
            filteredData.setPredicate(aniversario -> 
                                      aniversario.getNome().contains(newValue));
            
            //aplicando filtro ao SortedList
            SortedList<Aniversario> sortedData = new SortedList<>(filteredData);

            //fazendo binding entre sortedData e a tableview
            //sortedData.comparatorProperty().bind(tabelaAniversarios.comparatorProperty());
            
            //adicionando dados filtrados e ordenados à tabela
            tabelaAniversarios.setItems(sortedData);
            
        }
    }
    
    public void loadTabela(){
        //preenchendo tabela
        observableList = FXCollections.observableArrayList(DataLoader.load());
        tabelaAniversarios.setItems(observableList);
    }
    
    public void closeApp() throws IOException{
        Platform.exit();
    } 
    
    public LocalDate getLocalDateFromString(String dataString){
        //converter String para LocalDate
        String dia = dataString.substring(0, 2);
        String mes = dataString.substring(3, 5);
        String ano = dataString.substring(6, 10);

        LocalDate dataLocalDate = LocalDate.of(
                                   Integer.parseInt(ano), 
                                   Integer.parseInt(mes), 
                                   Integer.parseInt(dia));
        
        return dataLocalDate;
    }
    
    public void addAniversario(){
        if(tabelaAniversarios.getSelectionModel().getSelectedItem() == null){
            Aniversario ss = new Aniversario(
                                DataLoader.gerarId(), 
                                txtNome.getText(),
                                txtDataAniversario.valueProperty().getValue() );

            DataLoader.addAniversario(ss);
            observableList.setAll(
                    FXCollections.observableArrayList(DataLoader.lista));
        }
        limparCampos();
        JOptionPane.showMessageDialog(null, "Salvo!");
    } 
    
    public void delServico(){
        Aniversario ss = (Aniversario) tabelaAniversarios.getSelectionModel().getSelectedItem();
        DataLoader.delAniversario(ss);
        observableList.setAll(FXCollections.observableArrayList(DataLoader.lista));
        limparCampos();
        JOptionPane.showMessageDialog(null, "Excluído!");
    } 
    
    public void limparCampos(){
        tabelaAniversarios.getSelectionModel().clearSelection();
        txtId.setText("");
        txtNome.setText("");
        txtDataAniversario.setValue(null);
        txtNome.requestFocus();
    } 
}


/*
    BONUS


class AniversarioSelecionadoListener implements ChangeListener<Aniversario>{
        @Override
        public void changed(ObservableValue<? extends Aniversario> observable, 
                Aniversario oldValue, Aniversario newValue) {
                        //definindo binding
            if (oldValue !=null) {
                txtId.textProperty().unbindBidirectional(
                        oldValue.idProperty());
                txtNome.textProperty().unbindBidirectional(
                        oldValue.nomeProperty());
                txtDataAniversario.valueProperty().unbindBidirectional(
                        oldValue.dataAniversarioProperty());
            }
            if (newValue !=null){
                txtId.textProperty().bindBidirectional(
                        newValue.idProperty(), NumberFormat.getNumberInstance());
                txtNome.textProperty().bindBidirectional(
                        newValue.nomeProperty());
                txtDataAniversario.valueProperty().bindBidirectional(
                        newValue.dataAniversarioProperty());
                
            }
        }
        
    }



        dataColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Aniversario, LocalDate>, ObservableValue<String>>() {
        @Override 
        public ObservableValue<String> call(TableColumn.CellDataFeatures<Aniversario, LocalDate> c) {
            System.out.println("------------>" + formatter.format(c.getValue().getData()) );
            return Bindings.createObjectBinding(() -> formatter.format(c.getValue().getData()));

        }
        });
        
        
    Formatar coluna da tabela...
    ((TableColumn )(tabelaAniversarios.getColumns().get(2)) ).setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Aniversario, String>, ObservableValue<String>>() {
    @Override 
    public ObservableValue<String> call(TableColumn.CellDataFeatures<Aniversario, String> c) {
        return new SimpleStringProperty( formatter.format(c.getValue().getData()) );
    }
    });
    
    Binding LocalDate
    txtSenha.textProperty().bindBidirectional(
                        newValue.dataProperty(), 
                        new LocalDateFormatter());
       
    Binding Number
    txtSenha.textProperty().bindBidirectional(
                        newValue.numeroProperty(), 
                        NumberFormat.getNumberInstance());*/
        
    