package coletorweb;
 
import java.io.IOException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.jsoup.Connection;
 
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
 
public class ColetorWebFuncionando_CaseSIPAC {
 
    public static void main(String[] args) {
        
        final String USER_AGENT = " Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36";  
        String loginFormUrl = "https://sig.ifam.edu.br/sipac/?modo=classico";  
        String loginActionUrl = "https://sig.ifam.edu.br/sipac/logon.do"; 
        
        try {
            
            // for avoiding javax.net.ssl.SSLProtocolException: handshake alert:  unrecognized_name
			System.setProperty("jsse.enableSNIExtension", "false");
			
			// WARNING: do it only if security isn't important, otherwise you have 
			// to follow this advices: http://stackoverflow.com/a/7745706/1363265
			// Create a trust manager that does not validate certificate chains
			TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager(){
			    public X509Certificate[] getAcceptedIssuers(){return null;}
			    public void checkClientTrusted(X509Certificate[] certs, String authType){}
			    public void checkServerTrusted(X509Certificate[] certs, String authType){}
			}};
			
			// Install the all-trusting trust manager
			try {
			    SSLContext sc = SSLContext.getInstance("TLS");
			    sc.init(null, trustAllCerts, new SecureRandom());
			             HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			} catch (Exception e) {
			    ;
			}
            
            //grab login form page first
            Connection.Response loginForm = 
                    Jsoup.connect(loginFormUrl).method(Connection.Method.GET).userAgent(USER_AGENT).execute();  
            Document loginDoc = loginForm.parse(); // this is the document that contains response html

            HashMap<String, String> cookies = new HashMap<>();  
            cookies.putAll(loginForm.cookies()); // save the cookies, this will be passed on to next request  

            System.out.println("Fetched login page");            
            
            //String authToken = loginDoc.select("input[name='authenticity_token']")  
            //.first()  
            //.attr("value");  
            
            //System.out.println(""+authToken);

            //lets make data map containing all the parameters and its values found in the form
            Map<String, String> mapParams = new HashMap<String, String>();
            mapParams.put("width", "1366");  
            mapParams.put("height", "768");  
            mapParams.put("login", "jsantos");  
            mapParams.put("senha", "");  
            
           // mapParams.put("authenticity_token", authToken);  
            
            Connection.Response homePage = Jsoup.connect(loginActionUrl)  
            .cookies(cookies)  
            .data(mapParams)  
            .method(Connection.Method.POST)  
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