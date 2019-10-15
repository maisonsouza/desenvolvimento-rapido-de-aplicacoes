package coletorweb;
 
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.jsoup.Connection;
 
import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
 
public class ColetorWebFuncionando_CaseGitHub {
 
    public static void main(String[] args) {
        
        final String USER_AGENT = " Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36";  
        String loginFormUrl = "https://github.com/login";  
        String loginActionUrl = "https://github.com/session"; 
        
        try {
            
            //grab login form page first
            Connection.Response loginForm = 
                    Jsoup.connect(loginFormUrl).method(Connection.Method.GET).userAgent(USER_AGENT).execute();  
            Document loginDoc = loginForm.parse(); // this is the document that contains response html

            HashMap<String, String> cookies = new HashMap<>();  
            cookies.putAll(loginForm.cookies()); // save the cookies, this will be passed on to next request  

            System.out.println("Fetched login page");            
            
            String authToken = loginDoc.select("input[name='authenticity_token']")  
            .first()  
            .attr("value");  
            
            System.out.println(""+authToken);

            //lets make data map containing all the parameters and its values found in the form
            Map<String, String> mapParams = new HashMap<String, String>();
            mapParams.put("commit", "Sign in");  
            mapParams.put("utf8", "e2 9c 93");  
            mapParams.put("login", "mds.joyce@gmail.com");  
            mapParams.put("password", "");  
            mapParams.put("authenticity_token", authToken);  
            
            Connection.Response homePage = Jsoup.connect(loginActionUrl)  
            .cookies(cookies)  
            .data(mapParams)  
            .method(Connection.Method.POST)  
            .userAgent(USER_AGENT)  
            .execute();  

             System.out.println(homePage.parse().html());  

            
            /*
             * For all the subsequent requests, you need to send
             * the mapLoggedInCookies containing cookies
             */
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}