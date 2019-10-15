package pessoa.mvc;

import pessoa.controller.PessoaController;
import pessoa.view.PessoaView;

public class PessoaMVC {
    
    public static void main(String args[]){
        
        PessoaView theView = new PessoaView();
        PessoaController theController = new PessoaController(theView);
        theView.setVisible(true);
        
    }
}
