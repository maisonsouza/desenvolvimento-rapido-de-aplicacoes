package managedBean;

import conexao.ConnectionFactory;
import dao.UsuarioDAO;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import modelo.Usuario;

@ManagedBean
public class CadUsuarioBean {
    
    private Usuario usuario = new Usuario();
    private UsuarioDAO dao =  new UsuarioDAO(ConnectionFactory.getEntityManager());
    
    public String cadastra(){        
        usuario = dao.save(usuario);
        
        if(usuario != null){
             FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, 
                        "Cadastro ok!!",
                        "Tudo certo!"));             
        }else{
             FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                        "Cadastro NÃO ok!!" ,
                        "Nada certo!"));
        }
        
        return "/faces/formCadUsuario";
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
