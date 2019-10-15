
package conceitosOO.basicos.produto;

//classe de execução

public class ExecProduto {

    public static void main(String args[]){
        
        //criando objeto..
        Produto meuProduto = new Produto();
        
        //acessando atributos..
        meuProduto.codigo = 1;
        meuProduto.nome = "Arroz";
        meuProduto.valor = 2.00;
        
        //imprimindo 
        System.out.println("Produto: " + meuProduto.codigo + 
                "\nNome: " + meuProduto.nome +
                "\nValor: " + meuProduto.valor);
        
        //executando método
        double desconto = 10;
        System.out.println("\nDesconto:" + desconto);
        double valorComDesconto = 
                meuProduto.calcularDesconto(desconto);
        System.out.println("\nValor com desconto: " +
                valorComDesconto);
    
    }
    
}
