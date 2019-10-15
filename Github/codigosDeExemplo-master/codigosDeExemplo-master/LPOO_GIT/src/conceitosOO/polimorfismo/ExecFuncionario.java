/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oo.polimorfismo;

public class ExecFuncionario {
    
    public static void main(String args[]){
        
        Professor p = new Professor();
        p.setNome("Joyce");
        p.setSalarioBruto(1000.00);
        double sp = p.calcSalarioLiquido(100.00);
        
        Gerente g = new Gerente();
        g.setNome("Joyce");
        g.setSalarioBruto(1000.00);
        g.setBonus(500.00);
        double sg = g.calcSalarioLiquido(100.00);
        
        System.out.println(
                "Salário Professor: " + sp + "\n"
              + "Salário Gerente: " + sg);
        
    }
    
}
