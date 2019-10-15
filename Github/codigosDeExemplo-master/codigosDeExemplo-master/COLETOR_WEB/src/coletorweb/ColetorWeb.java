/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coletorweb;

import java.io.IOException;
import java.util.HashMap;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author joyce.miranda
 */
public class ColetorWeb {

    static String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36";
    static String loginFormUrl = "http://academico.ifam.edu.br/qacademico/index.asp?t=1000";  
    static String loginActionUrl = "http://academico.ifam.edu.br/qacademico/lib/validalogin.asp";  
    static String Submit = "OK";
    static String LOGIN = "jsantos";  
    static String SENHA = "jOmS2410"; 
    static String TIPO_USU = "2";
    static HashMap<String, String> cookies = new HashMap<>();  
    static HashMap<String, String> formData = new HashMap<>(); 
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Connection.Response loginForm = Jsoup.connect(loginFormUrl)
                                        .method(Connection.Method.GET)
                                        .userAgent(USER_AGENT)
                                        .execute();  
      
        
        //String conteudo = loginForm.parse().html();
        //System.out.println(conteudo);
        
        
        Document loginDoc = loginForm.parse(); // this is the document that contains response html
        
        cookies.putAll(loginForm.cookies()); // save the cookies, this will be passed on to next request  
       
        
        formData.put("Submit", Submit);  
        formData.put("LOGIN", LOGIN);  
        formData.put("SENHA", SENHA);  
        formData.put("TIPO_USU", TIPO_USU);  
        
      /* Connection.Response homePage = Jsoup.connect(loginActionUrl)  
            .cookies(cookies)  
            .data(formData)  
            .method(Connection.Method.POST)  
            .userAgent(USER_AGENT)  
            .execute();  
       
                System.out.println(homePage.parse().html()); 
*/

       Connection.Response res = Jsoup.connect(loginActionUrl)
            .data(formData)
            .method(Connection.Method.POST)
            .execute();

        Document doc = res.parse();
        String sessionId = res.cookie("ASPSESSIONIDCSCDADAS"); 
        
        System.out.println("" + sessionId);
        
        Document doc2 = Jsoup.connect("http://academico.ifam.edu.br/qacademico/index.asp?t=3000")
        .cookie("ASPSESSIONIDCSCDADAS", sessionId)
        .get();
        
        System.out.println(doc2.html());
       

    }
    
}

 /**  
        * Get the value of authenticity_token with the CSS selector we saved before  
        **/  
        /*  String authToken = loginDoc.select("#login > form > div:nth-child(1) > input[type=\"hidden\"]:nth-child(2)")  
             .first()  
             .attr("value");  
        System.out.println(authToken);*/
