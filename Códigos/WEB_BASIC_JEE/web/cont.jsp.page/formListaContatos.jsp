<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <body>
       Listando Contatos:
       
       <jsp:useBean id="dao" class="cont.jsp.dao.ContatoDAO" />
       
       <c:forEach var="contato" items="${dao.listaContatos}">
           
           <br/> ${contato.nome} 
           
       </c:forEach>
       
    </body>
</html>

