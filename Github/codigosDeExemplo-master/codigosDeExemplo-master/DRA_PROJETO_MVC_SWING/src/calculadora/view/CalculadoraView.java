/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.view;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jhoyce
 */
public class CalculadoraView extends JFrame {
    
    JPanel painel = new JPanel();
    JTextField txtNum1 = new JTextField(5);
    JTextField txtNum2 = new JTextField(5);
    JTextField txtResultado = new JTextField(5);
    JButton btnSomar = new JButton("Somar");
    
    public CalculadoraView(){        
        this.setSize(400, 200);        
        painel.add(txtNum1);
        painel.add(txtNum2);
        painel.add(btnSomar);
        painel.add(txtResultado);        
        this.add(painel);   
    }

    public String getTxtNum1(){
        return txtNum1.getText();
    }
        
    public String getTxtNum2(){
        return txtNum2.getText();
    }
    
    public void setResultado(String resultado){
        txtResultado.setText(resultado);
    }
    
    public void addBtnSomarListener(ActionListener listenForBtnSomar){
        btnSomar.addActionListener(listenForBtnSomar);
    }
    
    public void displayMensagemDeErro(String msg){
        JOptionPane.showMessageDialog(this, msg);
    }
    
}
