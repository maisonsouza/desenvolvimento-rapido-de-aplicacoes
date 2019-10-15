/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curso.mvc;

import curso.controller.CursoListarController;
import curso.model.Curso;
import curso.view.CursoListarView;

/**
 *
 * @author Jhoyce
 */
public class CursoListarMVC {
    
    public static void main(String[] args){
        CursoListarView theView = new CursoListarView();
        
        CursoListarController theController = 
                new CursoListarController(theView);
    }
    
}
