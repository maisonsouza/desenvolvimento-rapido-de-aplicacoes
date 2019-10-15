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

@WebServlet("/adicionaContatoMVC")
public class AdicionaContatoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {    

            /******* log *******/
            System.out.println("Criando um novo contato");            
            /*******acessando bean *******/
            Contato contato = new Contato(0, 
                    request.getParameter("nome"), 
                    request.getParameter("email"), 
                    request.getParameter("telefone"));            
            /*******adicionando ao BD *******/
            ContatoDAO dao = new ContatoDAO();
            dao.addContato(contato);            
            /*******  ok *******/
            RequestDispatcher rd = 
                    request.getRequestDispatcher("contato-adicionado.jsp");
            rd.forward(request, response);
    }
}
