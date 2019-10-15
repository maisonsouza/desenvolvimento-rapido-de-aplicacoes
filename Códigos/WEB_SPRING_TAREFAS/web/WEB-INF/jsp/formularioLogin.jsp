<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>


<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" href="<c:url value='/resources/css/default.css'/>" 
    </head>
    <body>
        <h2>Página de Login</h2>
        <div class="msgErro">${msgLoginInvalido}</div><br>
        <form action="<c:url value='/efetuaLogin'/>" method="post">
            Login: <input type="text" name="login" /> <br><br>
            Senha: <input type="password" name="senha" /> <br><br>
            <input type="submit" value="Entrar" />
            <input type="button" value="Voltar" onclick="history.back()" />
        </form>
    </body>
</html>
