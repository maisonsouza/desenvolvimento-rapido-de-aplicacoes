/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conta.mvc;

import conta.model.ContaModel;
import conta.view.ContaView;
import conta.controller.ContaController;

/**
 *
 * @author Jhoyce
 */
public class ContaMVC {
    
    public static void main(String[] args){
        ContaModel theModel = new ContaModel();
        ContaView theView = new ContaView();
        
        ContaController theController = new ContaController(theModel, theView);
        
        theView.setVisible(true);
    }
    
}
