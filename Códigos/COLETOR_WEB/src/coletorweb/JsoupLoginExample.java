package coletorweb;
 
import static coletorweb.ColetorWeb.loginActionUrl;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.jsoup.Connection;
 
import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
 
public class JsoupLoginExample {
 
    public static void main(String[] args) {
        
        
        try {
            
           
            
            //grab login form page first
            Response loginPageResponse = 
                    Jsoup.connect("https://servidor.sigepe.planejamento.gov.br/SIGEPE-PortalServidor/")
                     .method(Connection.Method.GET)
                     .validateTLSCertificates(false)
                    .followRedirects(true)
                    .execute();
            
            System.out.println("Fetched login page");
             System.out.println(""+loginPageResponse.parse().text());
            
            //get the cookies from the response, which we will post to the action URL
            //Map<String, String> mapLoginPageCookies = loginPageResponse.cookies();
            
            Map<String, String> mapLoginPageCookies = new HashMap<String, String>();
           
            mapLoginPageCookies.putAll(loginPageResponse.cookies()); // save the cookies, this will be passed on to next request  
                         
            
            //lets make data map containing all the parameters and its values found in the form
            Map<String, String> mapParams = new HashMap<>();
                        
            mapParams.put("Submit", "11466031f3a14e398ff29fbf974343e9");  
            mapParams.put("LOGIN", "10169d90874b10af8439ce97970edece");  
            mapParams.put("SENHA", "11b73953b60884cb82d9651abe1dbe81");  
            mapParams.put("TIPO_USU", "17c68b0ba91a4dadbfeb80228aa1a906");  
            
            //URL found in form's action attribute
            String strActionURL = "http://academico.ifam.edu.br/qacademico/lib/validaLogin.asp";
            
            Document doc = Jsoup.connect(strActionURL)
            .data(mapParams)
            .method(Connection.Method.POST)
            .cookies(mapLoginPageCookies)
                    .followRedirects(true)
            .post();
            
            System.out.println(""+doc.text());
            
          //  System.out.println(response.statusCode() + "\n" + response.parse().text());

           
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}