package managedBean;

import conexao.ConnectionFactory;
import dao.UsuarioDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import modelo.Usuario;

@ManagedBean
public class ListaUsuariosBean {
    
    private UsuarioDAO dao =  new UsuarioDAO(ConnectionFactory.getEntityManager());
    private List<Usuario> listaUsuarios = dao.listaUsuarios();;

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    
    
}
