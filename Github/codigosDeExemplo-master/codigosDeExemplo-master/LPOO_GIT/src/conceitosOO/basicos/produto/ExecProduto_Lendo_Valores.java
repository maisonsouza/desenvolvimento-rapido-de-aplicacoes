
package conceitosOO.basicos.produto;

//classe de execução

import javax.swing.JOptionPane;

public class ExecProduto_Lendo_Valores {

    public static void main(String args[]){
            
        //criando objeto..
        Produto meuProduto = new Produto();
        
        //lendo valores
        String entrada = JOptionPane.showInputDialog
        ("Informe o código do produto:");
        meuProduto.codigo = Integer.parseInt(entrada);
        
        meuProduto.nome = JOptionPane.showInputDialog
        ("Informe o nome do produto:");
        
        entrada = JOptionPane.showInputDialog
        ("Informe o valor do produto:");
        meuProduto.valor = Double.parseDouble(entrada);
        
        //imprimindo 
        JOptionPane.showMessageDialog(null,
                "Produto: " + meuProduto.codigo + 
                "\nNome: " + meuProduto.nome +
                "\nValor: " + meuProduto.valor);
        
    }
    
}
