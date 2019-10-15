package calculadora.mvc;


import calculadora.controller.CalculadoraController;
import calculadora.view.CalculadoraView;

public class CalculadoraMVC {
    
    public static void main(String args[]){
        
        CalculadoraView theView = new CalculadoraView();
        CalculadoraController controller = new CalculadoraController(theView);        
    }
    
}
