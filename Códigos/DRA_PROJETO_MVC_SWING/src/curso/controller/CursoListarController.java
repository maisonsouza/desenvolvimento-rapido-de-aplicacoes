/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curso.controller;

import curso.dao.CursoDAO;
import curso.model.Curso;
import curso.view.CursoDetalharView;
import curso.view.CursoListarView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class CursoListarController {
    
    CursoListarView theView;
    Vector<Curso> listaCursos;
        
    public CursoListarController(CursoListarView theView){
        this.theView = theView;        
        theView.addBtnListarListener(new ListarCursoListener());
        theView.addTblCursosClickListener(new DetalharCursoListener());
        theView.setVisible(true);
    }
    
    class ListarCursoListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            
            String  valorBuscado = theView.getTxtValorBuscado();
            
            CursoDAO dao = new CursoDAO();
            listaCursos = dao.listar(valorBuscado);
            
            Vector conjuntoLinhas = new Vector();
        
            for(Curso curso: listaCursos){
                Vector linha = new Vector();
            
                linha.add(curso.getIdCurso());
                linha.add(curso.getSigla());
                linha.add(curso.getDescricao());
            
                conjuntoLinhas.add(linha);
            }
        
            Vector conjuntoColunas = new Vector();
            conjuntoColunas.add("Código"); 
            conjuntoColunas.add("Sigla");
            conjuntoColunas.add("Descrição");
            
            DefaultTableModel modeloTabela = 
                    new DefaultTableModel(conjuntoLinhas, conjuntoColunas);
            theView.setTblCursos(modeloTabela); 
        }       
    }
    
     class DetalharCursoListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            int indice = theView.getTblCursos();
            Curso curso = listaCursos.get(indice);
            new CursoDetalharView(curso).setVisible(true);       
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
       
              
    }
   }
  
