package managedBean;

import model.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
public class TelaUsuario {

    private Usuario user;
    @ManagedProperty(value = "#{listaUsuarioBean}")
    private ListaUsuarioBean listaUsuarioBean;

    public TelaUsuario() {
        user = new Usuario();
    }

    public Usuario getUser() {
        return user;
    }
    
    public void setUser(Usuario user) {
        this.user = user;
    }

    public ListaUsuarioBean getListaUsuarioBean() {
        return listaUsuarioBean;
    }

    public void setListaUsuarioBean(ListaUsuarioBean listaUsuarioBean) {
        this.listaUsuarioBean = listaUsuarioBean;
    }
        
    public String cadastrar(){
        user.setId(user.hashCode());
        listaUsuarioBean.getListaUsuario().add(user);
        return "telaUsuario";
    }
    
    public void remover(Usuario user){
        listaUsuarioBean.getListaUsuario().remove(user);
    }
    
    public void carregarDados(Usuario user){
        this.user.setId(user.getId());
        this.user.setEmail(user.getEmail());
        this.user.setSenha(user.getSenha());
    }
    
    public String alterar(){        
        for (Usuario user : listaUsuarioBean.getListaUsuario()) {
            if(user.getId() == this.user.getId()){
                user.setEmail(this.user.getEmail());
                user.setSenha(this.user.getSenha());
                break;
            }
        }
        return "telaUsuario";
    }

}
