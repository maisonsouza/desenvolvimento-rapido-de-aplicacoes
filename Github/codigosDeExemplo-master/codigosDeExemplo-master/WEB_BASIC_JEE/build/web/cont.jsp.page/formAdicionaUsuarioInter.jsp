<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
    <head>
        
    </head>
    <body>

        <c:if test="${not empty param.lang}">
            <fmt:setLocale value="${param.lang}" />
            <fmt:setBundle basename="general.properties.messages" />
        </c:if>
        
        <h1><fmt:message key="site.titulo"/></h1>
        
        <form method="post" 
              action="${pageContext.request.contextPath}/adicionaUsuario" >
            <fmt:message key="campo.email"/>
            <input type="text" name="email">
            <br><br>
            <fmt:message key="campo.senha"/>
            <input type="password" name="senha">
            <br><br>
            <input type="submit" value="<fmt:message key="botao.enviar"/>">
            <input type="submit" value="<fmt:message key="botao.cancelar"/>">
        </form>
        
    </body>
</html>
