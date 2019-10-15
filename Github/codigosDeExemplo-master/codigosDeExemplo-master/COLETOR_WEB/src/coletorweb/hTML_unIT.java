/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coletorweb;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
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
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author joyce.miranda
 */
public class hTML_unIT {
    
    public static void main(String[] args) throws IOException {
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
			
                        final String MY_COMPANY_LOGIN_URL = "https://sig.ifam.edu.br/sipac/";
                        
			// Authentication example
			// 1. GET request for login form, hidden fields and cookies
			Connection.Response loginForm = Jsoup.connect(MY_COMPANY_LOGIN_URL)
							            .method(Connection.Method.GET)
							            .execute();
			
			Document doc = loginForm.parse();
			// eventually get hidden fields generated dinamically by the server
		       /* Elements urlFwdEl = doc.getElementsByAttributeValue("name", "urlFwd");
			String forwardingUrl = urlFwdEl.get(0).val();
			Elements tokenEl = doc.getElementsByAttributeValue("name", "tokenLogin");
			String token = tokenEl.get(0).val();
			*/
			// 2. POST authentication
                        
                        final String MY_COMPANY_AUTH_URL = "https://sig.ifam.edu.br/sipac/logon.do";
                        
			Connection.Response auth = Jsoup.connect(MY_COMPANY_AUTH_URL)
								.timeout(10*1000)
								.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36")
								.referrer(MY_COMPANY_LOGIN_URL)
							 .data("login", "jsantos")
							 .data("senha", "jOmS2410")
                                                         .data("width", "1366")
							 .data("height", "768")
							 //.data("urlFwd", forwardingUrl)
							 //.data("tokenLogin", token)
							 .cookies(loginForm.cookies()) // important!
						        .method(Connection.Method.POST)
                                .followRedirects(true)
							 .execute();
							 
                     Document document = auth.parse();
                     String htmlAuth = document.toString();
                     Document docPage = Jsoup.parse(htmlAuth);
                     
                     System.out.println(""+ docPage.text());
                     
                     // repeat this methods combination
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    
}
