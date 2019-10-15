package oo.polimorfismo;

public class Gerente extends Funcionario {
    
    private double bonus;
    private String setor;

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
    
    public double calcSalarioLiquido(double desconto){
        return this.getSalarioBruto() 
                - desconto + this.bonus;
    }
    
    
}
