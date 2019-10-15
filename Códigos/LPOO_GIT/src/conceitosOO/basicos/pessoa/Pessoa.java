package conceitosOO.basicos.pessoa;

public class Pessoa {
   
    //declaracao dos atributos
   public long cpf;
   public String nome;
   public int anoNascimento;
   
   //modificou o construtor
   public Pessoa(long cpf, String nome, int anoNascimento){
       this.cpf = cpf;
       this.nome = nome;
       this.anoNascimento = anoNascimento;
   }
   
   //declaracao do método
   public int calcularIdade(int anoAtual){
       return (anoAtual - this.anoNascimento);
   }
    
}
