package conceitosOO.basicos.pessoa;

import java.time.LocalDate;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class ExecPessoa {
    
    public static void main(String[] args){
        
        //interacao com usuario
        long cpf = 
                Long.parseLong(JOptionPane.showInputDialog(null, "Cpf:"));
        String nome = 
                JOptionPane.showInputDialog(null, "Nome:");
        int anoNascimento = 
                Integer.parseInt(JOptionPane.showInputDialog(null, "Ano de Nascimento:"));
        
        //criar o objeto
        Pessoa p = new Pessoa(cpf, nome, anoNascimento);
        
        //Calendar c = Calendar.getInstance();
        //int anoAtual = c.get(Calendar.YEAR);
        
        int anoAtual = LocalDate.now().getYear();
        
        int idade = p.calcularIdade(anoAtual);
        
        //System.out.println("A idade de " + p.nome + " é: " + idade);
        
        System.out.println("A idade de " + p.nome + " é: " + p.calcularIdade(anoAtual));
   
    }
    
}
