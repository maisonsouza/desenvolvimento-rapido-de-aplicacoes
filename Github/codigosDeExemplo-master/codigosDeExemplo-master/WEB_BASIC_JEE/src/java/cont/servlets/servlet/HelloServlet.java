package cont.servlets.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(
            HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>Hello Servlet!!</body>");
        out.println("</html>");
    }
    
}
