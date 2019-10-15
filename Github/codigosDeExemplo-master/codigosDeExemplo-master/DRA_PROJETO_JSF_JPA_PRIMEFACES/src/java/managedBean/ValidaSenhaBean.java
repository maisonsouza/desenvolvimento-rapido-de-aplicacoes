package managedBean;

import conexao.ConnectionFactory;
import dao.UsuarioDAO;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import modelo.Usuario;

@ManagedBean
public class ValidaSenhaBean {
    
    private Usuario usuario = new Usuario() ;
    private UsuarioDAO dao =  new UsuarioDAO(ConnectionFactory.getEntityManager());

    public String validaSenha(){
                
        boolean validou = dao.validaSenha(usuario);
        if(validou){
             return "/index";
        }else{
             FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                        "Usuário não encontrado!",
                        "Erro no Login!"));
                    return "/faces/formLogin";
        }
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }   
    
}
