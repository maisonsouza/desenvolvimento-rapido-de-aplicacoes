package cont.servlets.servlet;

import cont.servlets.bean.Contato;
import cont.servlets.dao.ContatoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/adicionaContato")
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
            boolean inseriu = dao.addContato(contato);            
            /*******  ok *******/
            PrintWriter out = response.getWriter();
            out.print("<html><body>");
            if(inseriu){
               out.println("Contato " +
                       contato.getEmail()+ 
                       " inserido com Sucesso!!");
            }else{
               out.println("Falha ao inserir!!"); 
            }
            out.print("</body></html>");
    }
}
