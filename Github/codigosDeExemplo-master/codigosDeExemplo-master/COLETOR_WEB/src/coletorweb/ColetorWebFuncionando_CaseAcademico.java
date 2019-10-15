package coletorweb;
 
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 
public class ColetorWebFuncionando_CaseAcademico {
 
    public static void main(String[] args) throws IOException{
        
       String url = "http://academico.ifam.edu.br/qacademico/index.asp?t=1000";
       
       System.out.println("Criando conexão com o navegador...");
       
        try (WebClient webClient = new WebClient(BrowserVersion.CHROME)) 
        {
            //set warning presenter to false
            java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(java.util.logging.Level.OFF);
            System.out.println("Conexão criada...");
            System.out.println("Fazendo Login...");
            HtmlPage pagePrincipal = webClient.getPage(url);
            /*   //alternativa para usar HTMLUnit com fragmento HTML
            HtmlPage page = HTMLParser.parseHtml(response, webClient.getCurrentWindow());
            */
            pagePrincipal.getElementById("txtLogin").setAttribute("value", "jsantos");
            pagePrincipal.getElementById("txtSenha").setAttribute("value", "");
            HtmlSubmitInput anchor = (HtmlSubmitInput) pagePrincipal.getElementById("btnOk");
            anchor.click();
            System.out.println("Login realizado...");
            //System.out.println("\n"+pagePrincipal.getUrl().toString());
            System.out.println("Extraindo Disciplinas...");
            String urlDiarios = "http://academico.ifam.edu.br/qacademico/index.asp?t=3061";
            HtmlPage pageSecundaria = webClient.getPage(urlDiarios);
            //System.out.println("\n"+subpage.asXml());
            Document docDiarios = Jsoup.parseBodyFragment(pageSecundaria.asXml());
            Elements diarios = docDiarios.select("tr.conteudoTexto td:nth-child(1) strong");
            String urlDiario = "http://academico.ifam.edu.br/qacademico/index.asp?t=3066&MODO=FALTAS&ETAPA=1&N_ETAPA=UN";
            String urlFim = "";
            HtmlPage pageFim = null;
            for (Element codDiario : diarios) {
                urlFim = urlDiario + "&COD_PAUTA=" + codDiario.text().trim();
                //System.out.println("urlFim: " + urlFim);
                pageFim = webClient.getPage(urlFim);
                Document docDiario = Jsoup.parseBodyFragment(pageFim.asXml());
                String nomeDisciplina = docDiario.select("tr:nth-child(2) > td.dado_cabecalho").text();
                System.out.println("Disicplina: " + nomeDisciplina);
                
                Elements matriculas = docDiario.select("td > a[tabindex='-1']");
                Elements nomes = docDiario.select("div > a[tabindex='-1']");
                for (int i = 0; i < nomes.size(); i++) {
                    System.out.println(""+matriculas.get(i).text() + " : " + nomes.get(i).text());
                }                
            }
            
        }
    }
}