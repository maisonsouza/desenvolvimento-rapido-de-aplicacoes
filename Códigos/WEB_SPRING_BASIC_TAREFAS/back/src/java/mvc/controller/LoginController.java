/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import javax.servlet.http.HttpSession;
import mvc.bean.Usuario;
import mvc.dao.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Joyce
 */
@Controller
public class LoginController  {
    
    private final UsuarioDAO dao;
    
    @Autowired
    public LoginController(UsuarioDAO dao) {
        this.dao = dao;
    }

    @RequestMapping("/formLogin")
    public String formLogin(){
        return "formularioLogin";
    }
    
    @RequestMapping("/adm")
    public String formMenuAdm(){
        return "menuAdm";
    }
    
    @RequestMapping("/efetuaLogin")
    public String efetuaLogin(Usuario user, HttpSession session){
        if(dao.validaUsuario(user)){
            session.setAttribute("usuarioLogado", user);
            session.removeAttribute("msgLoginInvalido");
            return "menuAdm";
        }else{
            session.setAttribute("msgLoginInvalido", "O login não foi validado!");
            return "redirect:formLogin";
        }
        
    }
    
    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
    
}
