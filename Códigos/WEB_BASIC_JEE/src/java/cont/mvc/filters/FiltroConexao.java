package cont.mvc.filters;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import cont.mvc.connection.ConnectionFactory;

@WebFilter("/connection")
public class FiltroConexao implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, 
            ServletResponse response, FilterChain chain) 
            throws IOException, ServletException {
        
        try {
            
            //estabelece conexao
            Connection connection = ConnectionFactory.getConnection();
            
            //armazena objeto no request
            request.setAttribute("connection", connection);
            
            //prossegue execução do request
            chain.doFilter(request, response);
            
            //fecha conexao
            connection.close();
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }        
    }

    @Override
    public void destroy() {
    }

    
    
}
