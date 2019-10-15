/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cont.mvc.logica;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cont.mvc.bean.Contato;
import cont.mvc.dao.ContatoDAO;

/**
 *
 * @author Joyce
 */
public class AdicionaContatoLogica implements Logica{
   
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) 
            throws Exception {
        
            /*******acessando bean *******/
            Contato contato = new Contato(0, 
                    request.getParameter("nome"), 
                    request.getParameter("email"), 
                    request.getParameter("telefone"));
            /*******recuperando conexao *******/
            Connection connection = (Connection) request
            .getAttribute("connection");
            /*******adicionando ao BD *******/
            ContatoDAO dao = new ContatoDAO(connection);
            dao.addContato(contato);            
            /*******  ok *******/
           return "cont.mvc.page/contato-adicionado.jsp";
    }    

   
}
