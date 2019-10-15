/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conta.controller;

import conta.model.ContaModel;
import conta.view.ContaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContaController {
    
    ContaView theView;
    
    public ContaController(ContaModel theModel, ContaView theView){
        this.theView = theView;
        theView.addBtnDepositarListener(new DepositarListener());
        theView.setVisible(true);
    }
    
    class DepositarListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int numero = Integer.parseInt(theView.getTxtNumero());
            double valorOperacao = 
                    Double.parseDouble(theView.getTxtValorOperacao());
            
            
            //camada Model
            ContaModel theModel = new ContaModel();
            theModel.setNumero(numero);
            boolean ok = theModel.depositarValor(valorOperacao);
            
            if(ok){
                theView.setTxtSaldo(Double.toString(theModel.getSaldo()));
                theView.showMessage("Operação realizada com sucesso.");
            }else{
                theView.showMessage("Valor deve ser maior que 0.");
            }
        }
        
    }
    
}
