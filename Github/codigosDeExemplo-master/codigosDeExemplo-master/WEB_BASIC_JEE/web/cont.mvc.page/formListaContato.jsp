<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--
<jsp:useBean id="dao" class="mvc.dao.ContatoDAO" />
<table>
    <c:forEach var="contato" items="${dao.listaContatos}">
        <tr>
            <td>${contato.nome}</td>
        </tr>
    </c:forEach>
</table>
--%>

<table>
    <c:forEach var="contato" items="${listaContatos}">
        <tr>
            <td>${contato.nome}</td>
        </tr>
    </c:forEach>
</table>
