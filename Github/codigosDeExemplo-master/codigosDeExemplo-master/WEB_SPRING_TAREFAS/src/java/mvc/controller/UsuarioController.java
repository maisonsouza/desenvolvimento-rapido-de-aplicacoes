/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import mvc.bean.Usuario;
import mvc.dao.UsuarioDAO;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
public class UsuarioController {
    
    private final UsuarioDAO dao;
    
    @Autowired
    public UsuarioController(UsuarioDAO dao) {
        this.dao = dao;
    }
    
    @RequestMapping("/formAdicionaUsuario")
    public String form(){
        return "usuario/formularioAdicionaUsuario";
    }
    
    
    @RequestMapping("/listaUsuarios")
    public String lista(Model model) throws IOException{
        List<Usuario> listaUsuarios = dao.listarUsuarios();
        
        setImagePath(listaUsuarios);
        
        for (Usuario listaUsuario : listaUsuarios) {
            System.out.println(""+ listaUsuario.getPhoto());
        }
        
        model.addAttribute("listaUsuarios", listaUsuarios);
        return "usuario/listagem-usuarios";
    }
    
    @RequestMapping(value="/adicionaUsuario", method=RequestMethod.POST)
    public String adiciona(HttpServletRequest request, Model model){
        /*
        Configuracoes necessárias
        Fonte: http://www.pablocantero.com/blog/2010/09/29/upload-com-spring-mvc/
        */
        try {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile multipartFile = multipartRequest.getFile("photo");
            
            String destinyPath = "C:\\PhotosNetbeans\\";
            if(!(new File(destinyPath)).exists()){
                (new File(destinyPath)).mkdir();
            }
            
            String photoName = multipartFile.getOriginalFilename();
            String photoPath = destinyPath + photoName;
                       
            File photoFile = new File(photoPath);
            multipartFile.transferTo(photoFile);
            
            //backup
            //File destinationDir = new File(applicationPath);
            //FileUtils.copyFileToDirectory(photoFile, destinationDir);
            
            Usuario user = new Usuario();
            user.setLogin(request.getParameter("login"));
            user.setSenha(request.getParameter("senha"));
            user.setPhoto(photoPath);           
            
            dao.adicionaUsuario(user);            
            return "usuario/usuario-adicionado";
            
        } catch (IOException ex) {
            model.addAttribute("erro", ex.toString());
            return "usuario/usuario-erro-adicao";
        } 
    }
    
    private void setImagePath(List<Usuario> listaUsuarios) throws IOException{
        
        for (Usuario usuario : listaUsuarios) {
            
            BufferedImage bImage = ImageIO.read(new File(usuario.getPhoto()));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write( bImage, "jpg", baos );
            baos.flush();
            byte[] imageInByteArray = baos.toByteArray();
            baos.close();                                   
            String b64 = DatatypeConverter.printBase64Binary(imageInByteArray);
            usuario.setPhoto(b64);
            
        }
            
    }
    
    /*
    @RequestMapping(value = "/form.html", method = RequestMethod.POST)
    public String upload(@RequestParam("name") String name,
        @RequestParam("file") MultipartFile  file) throws Exception {
    }
    
    */
    
   
    
}



