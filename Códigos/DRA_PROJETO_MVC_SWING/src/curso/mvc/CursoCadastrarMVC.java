/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curso.mvc;

import curso.controller.CursoCadastrarController;
import curso.model.Curso;
import curso.view.CursoCadastrarView;

/**
 *
 * @author Jhoyce
 */
public class CursoCadastrarMVC {
    
    public static void main(String[] args){
        CursoCadastrarView theView = new CursoCadastrarView();
       
        CursoCadastrarController theController = 
                new CursoCadastrarController(theView);
    }
    
}
