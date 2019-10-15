package interfaceGrafica;


import interfaceGrafica.Adicao;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TelaAdicao extends JFrame {
    
    //declarar componentes da tela
    JPanel painel = new JPanel();
    JLabel lblNum1 = new JLabel("Número 1: ");
    JLabel lblNum2 = new JLabel("Número 2: ");
    JLabel lblResultado = new JLabel("Resultado");
    JTextField txtNum1 = new JTextField();
    JTextField txtNum2 = new JTextField();
    JButton btnSomar = new JButton("Somar");
    
    //modificar o construtor
    //organizar componentes na janela
    public TelaAdicao(){
        iniciarComponentes();
    }
    
    public static void main(String[] args) {
        //carregar janela
        new TelaAdicao();
    }
    
    private void iniciarComponentes(){
        //definir do layout
        GridLayout grid = new GridLayout(3, 2, 5, 5);
        //aplicar layout ao painel
        painel.setLayout(grid);
        
        //adicionar componentes ao painel
        painel.add(lblNum1);
        painel.add(txtNum1);
        painel.add(lblNum2);
        painel.add(txtNum2);
        painel.add(btnSomar);
        painel.add(lblResultado);
        
        //adicionar o painel à janela
        add(painel);
        
        //adicionar acao ao botao
        btnSomar.addActionListener(new SomarListener());
        
        //configuracoes da janela
        setTitle("Tela de Adição de Valores");
        setBounds(100, 100, 300, 200);
        setVisible(true);
    }
    
    //criar classe aninhada
    //definir acao do botao somar
    class SomarListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            //recuperar valores da tela
            double num1 = Double.parseDouble(txtNum1.getText());
            double num2 = Double.parseDouble(txtNum2.getText());
            
            //instanciar classe modelo
            Adicao ad = new Adicao(num1, num2);
            //executar metodo
            double resultado = ad.somar();
            
            //apresentar valor na tela
            lblResultado.setText(Double.toString(resultado));
        }        
    }
    
}
