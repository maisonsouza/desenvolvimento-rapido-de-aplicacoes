/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cont.servlets.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adicionaUsuario")
public class AdicionaUsuarioServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException {
        
        
        
        //recuperando valores
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        //exibindo valores
        PrintWriter out = response.getWriter();
        out.print("<html><body>");
        out.println("Usuário: " + email + " Senha: " + senha);
        out.print("</body></html>");
    }
}
