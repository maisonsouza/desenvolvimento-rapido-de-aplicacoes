package cont.mvc.logica;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cont.mvc.bean.Contato;
import cont.mvc.dao.ContatoDAO;

public class ListaContatoLogica implements Logica {
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        //Carrega lista de contato
        ContatoDAO dao = new ContatoDAO();
        List<Contato> listaContatos = dao.getListaContatos();
        
        //armazena lista em um request
        request.setAttribute("listaContatos", listaContatos);
        
        return "cont.mvc.page/formListaContato.jsp";       
    }    
}
