package pessoa.view;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PessoaView extends JFrame {
    
    private JPanel painel = new JPanel();
    private JTextField txtDataNascimento = new JTextField(10);
    private JButton btnCalcIdade = new JButton("Calcular Idade");
    private JTextField txtIdade = new JTextField(10);
    
    public PessoaView(){        
        this.setSize(400,200);
        painel.add(txtDataNascimento);
        painel.add(btnCalcIdade);
        painel.add(txtIdade);
        this.add(painel);        
    }
    
    public String getTxtDataNascimento(){
        return this.txtDataNascimento.getText();  
    }
    
    public void setIdade(String idade){
        txtIdade.setText(idade);
    } 
    
    public void addBtnCalcIdadeListener(ActionListener listenerForBtnCalcIdade){
        btnCalcIdade.addActionListener(listenerForBtnCalcIdade);
    }
    
    public void showErrorMessage(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }
    
}
