package cont.mvc.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cont.mvc.logica.Logica;

@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet{

    String pacote = "cont.mvc.logica.";
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String acao = request.getParameter("logica");
        String nomeClasse = pacote + acao;
        
        System.out.println("-->" + nomeClasse);
        
        try {
            Class<?> classe = Class.forName(nomeClasse);
            Logica logica = (Logica) classe.newInstance();
            String pagina = logica.executa(request, response);
            RequestDispatcher rd = 
            request.getRequestDispatcher(pagina);
            rd.forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Exceção gerada pela lógica de negócios", e);
        }
    }    
}
