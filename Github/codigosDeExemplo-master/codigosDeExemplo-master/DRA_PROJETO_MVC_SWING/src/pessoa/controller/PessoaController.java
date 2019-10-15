package pessoa.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import pessoa.model.PessoaModel;
import pessoa.view.PessoaView;

public class PessoaController {

    private PessoaView theView;
    
    public PessoaController(PessoaView theView){
        this.theView = theView;        
        theView.addBtnCalcIdadeListener(new CalcularIdadeListener());
        theView.setVisible(true);
    }
    
    class CalcularIdadeListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //capturar dataNascimento da tela
            String txtDataNascimento = theView.getTxtDataNascimento();
            
            //recuperando LocalDate de uma String
            DateTimeFormatter formatador =DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataNascimento = LocalDate.parse(txtDataNascimento, formatador);
            
            //setar dataNascimento no modelo
            PessoaModel theModel = new PessoaModel();
            theModel.setDataNascimento(dataNascimento);
            
            //recuperar anoAtual
            int anoAtual = LocalDate.now().getYear();
            
            //executa metodo calcIdade do modelo
            int idade = theModel.calcIdade(anoAtual);
            
            theView.setIdade(Integer.toString(idade));            
        
        }
    
    }
}
