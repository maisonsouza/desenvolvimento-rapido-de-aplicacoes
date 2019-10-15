package calculadora.controller;

import calculadora.model.CalculadoraModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import calculadora.view.CalculadoraView;

public class CalculadoraController {
    
    private CalculadoraView theView;

    public CalculadoraController(CalculadoraView theView) {
        this.theView = theView;      
        this.theView.addBtnSomarListener(new SomarListener());
        this.theView.setVisible(true);
    }
    
    class SomarListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                
                double num1 = Double.parseDouble(theView.getTxtNum1());
                double num2 = Double.parseDouble(theView.getTxtNum2());

                CalculadoraModel theModel = new CalculadoraModel();
                
                theModel.setNum1(num1);
                theModel.setNum2(num2);
                double resultado = theModel.somar();

                theView.setResultado(Double.toString(resultado));
                
            }catch(NumberFormatException ex){
                theView.displayMensagemDeErro(
                        "Entre com dos valores numéricos!!");
            }
        }
    }
    
    
}
