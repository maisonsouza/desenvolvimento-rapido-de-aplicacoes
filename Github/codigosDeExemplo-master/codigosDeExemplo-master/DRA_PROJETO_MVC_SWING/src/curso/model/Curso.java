package curso.model;


public class Curso {
    
    private int idCurso;
    private String sigla;
    private String descricao;

    public Curso() {
    } 
    public Curso(int idCurso, String sigla, String descricao) {
        this.idCurso = idCurso;
        this.sigla = sigla;
        this.descricao = descricao;
    }

    public int getIdCurso() {
        return idCurso;
    }
    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }
    
    public String getSigla() {
        return sigla;
    }
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }  

    @Override
    public String toString() {
        return this.getDescricao();
    }
    
    
}
