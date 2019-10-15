<%-- 
    Document   : tarefa-adicionada
    Created on : Dec 10, 2015, 3:46:28 PM
    Author     : Joyce
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
    <body>
        <h1>Erro ao adicionar usuário!</h1>
        <div style="color:red">
            ${erro}
        </div>
        <br><br>
        <a href="<c:url value='/'/>">Voltar</a> 
    </body>
</html>
