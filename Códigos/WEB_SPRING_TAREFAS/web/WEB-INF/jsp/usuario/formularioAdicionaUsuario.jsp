<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
    <body>
        <h1>Formulário de Adição de Usuários</h1>
        <form action="<c:url value='/adicionaUsuario'/>" method="post" enctype="multipart/form-data">            
            <br>Login: 
            <input type="text" name="login" />
            <br><br>Senha: 
            <input type="password" name="senha" />
            <br><br>Photo:
            <input type="file" name="photo" />
            <br><br>
            <input type="submit" value="Adicionar">
            <br>       
        </form>
        <br>
        <a href="<c:url value='/index'/>">Voltar</a>
    </body>
</html>
