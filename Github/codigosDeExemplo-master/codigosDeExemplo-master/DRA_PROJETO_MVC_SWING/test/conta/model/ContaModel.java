/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conta.model;

public class ContaModel {
    
    private int numero;
    private double saldo;
    

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }
    
    public boolean depositarValor(double valor){
        if(valor > 0){
            this.saldo = this.saldo + valor;
            return true;
        }else{
            return false;
        }
    }
    
    
    
}
