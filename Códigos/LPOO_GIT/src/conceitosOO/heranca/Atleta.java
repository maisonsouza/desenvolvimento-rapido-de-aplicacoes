package conceitosOO.heranca;

public class Atleta {

    protected String nomeAtleta;
    protected double salario;
    protected int tempoContrato;

    public String getNomeAtleta() {
        return nomeAtleta;
    }

    public void setNomeAtleta(String nomeAtleta) {
        this.nomeAtleta = nomeAtleta;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getTempoContrato() {
        return tempoContrato;
    }

    public void setTempoContrato(int tempoContrato) {
        this.tempoContrato = tempoContrato;
    }
    
    public double calcValorContrato(){
        return this.salario * this.tempoContrato;
    }
    
}
