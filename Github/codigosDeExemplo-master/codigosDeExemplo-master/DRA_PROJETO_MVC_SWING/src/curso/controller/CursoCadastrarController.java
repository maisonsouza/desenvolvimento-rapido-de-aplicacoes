/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curso.controller;

import curso.dao.CursoDAO;
import curso.model.Curso;
import curso.view.CursoCadastrarView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CursoCadastrarController {
    
    CursoCadastrarView theView;
    
    public CursoCadastrarController(CursoCadastrarView theView){
        this.theView = theView;   
        theView.addBtnCadastrarEventListener(new CadastrarCursoListener());
        theView.setVisible(true);

    }
    
    class CadastrarCursoListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String  sigla = theView.getTxtSigla();
            String  descricao = theView.getTxtDescricao();            
            
            //camada modelo
            Curso curso = new Curso();
            curso.setSigla(sigla);
            curso.setDescricao(descricao);
            
            CursoDAO dao = new CursoDAO();
            boolean cadastrou = dao.cadastrar(curso);
            
            if(cadastrou){
                theView.showMessage("Cadastro realizado com sucesso");
            }else{
                theView.showMessage("Cadastro não realizado!!");
            }
        }       
    }
   }
  
