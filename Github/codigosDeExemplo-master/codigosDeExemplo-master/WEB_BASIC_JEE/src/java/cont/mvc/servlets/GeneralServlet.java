package cont.mvc.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cont.mvc.bean.Contato;
import cont.mvc.dao.ContatoDAO;

@WebServlet("/general/sistema") 
public class GeneralServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {        
        String acao = req.getParameter("logica");        
        ContatoDAO dao = new ContatoDAO();
        if(acao.equals("AdicionaContato")){
             Contato contato = new Contato(0, 
                    req.getParameter("nome"), 
                    req.getParameter("email"), 
                    req.getParameter("telefone"));            
            dao.addContato(contato);            
            RequestDispatcher rd = 
                    req.getRequestDispatcher("contato-adicionado.jsp");
            rd.forward(req, resp);
        }else if(acao.equals("ListaContatos")){
            //recupera lista do DAO
            //despacha para JSP
        }else if(acao.equals("RemoveContato")){
            //faz a remoção e redireciona para a lista
        }
        
    }
}
