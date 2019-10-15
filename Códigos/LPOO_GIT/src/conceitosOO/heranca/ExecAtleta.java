/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceitosOO.heranca;

public class ExecAtleta {

    public static void main(String args[]){
        
        AtletaFutebol af = new AtletaFutebol();
        af.setNomeAtleta("Neymar");
        af.setSalario(100000.00);
        af.setTempoContrato(12);
        af.setClube("Barcelona");
        af.setPosicao("atacante");
        double valorContratoAF = af.calcValorContrato();
        
        
        AtletaAtletismo aa = new AtletaAtletismo();
        aa.setNomeAtleta("Dayane dos Santos");
        aa.setSalario(12000.00);
        aa.setTempoContrato(6);
        aa.setModalidade("ginástica");
        double valorContratoAA = aa.calcValorContrato();
        
        
        System.out.println("Atletas de Futebol: \n"
                + " Nome: " + af.getNomeAtleta() 
                + " ValorContrato: " + valorContratoAF);
        
        System.out.println("Atletas de Atletismo: \n"
                + " Nome: " + aa.getNomeAtleta() 
                + " ValorContrato: " + valorContratoAA);

        
        
        
    }
    
}
