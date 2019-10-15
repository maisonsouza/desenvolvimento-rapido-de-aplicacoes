package conceitosOO.basicos.produto;

//nome da classe
public class Produto {

    //definição de atributos
    int codigo;
    String nome;
    double valor;
    
    //definindo métodos
    double calcularDesconto(double desc){
       double valorComDesconto = valor - (valor * desc/100);
       return valorComDesconto;
    }
    
    
}
