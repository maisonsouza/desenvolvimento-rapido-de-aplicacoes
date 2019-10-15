package crud;

public class SenhaServico_SemProperty {
    private String servico;
    private String login;
    private String senha;

    public SenhaServico_SemProperty(String servico, String login, String senha) {
        this.servico = servico;
        this.login = login;
        this.senha = senha;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
