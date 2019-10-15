<%-- 
    Document   : menuAdm
    Created on : Dec 29, 2015, 12:12:25 AM
    Author     : Joyce
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <body>
        <h3>Funcionalidades restritas aos administradores apenas!!</h3>
        Bem-Vindo(a), ${usuarioLogado.login}!
        
        <br><br>
        <a href="<c:url value='/formAdicionaTarefa'/>">Adicionar Tarefa</a>
        <br><br>
        <a href="<c:url value='/formAdicionaUsuario'/>">Adicionar Usuário</a>
        <br><br>
        <a href="<c:url value='/listaUsuarios'/>">Listagem de Usuários</a>
        <br><br>
        <a href="<c:url value='/logout'/>">Sair</a>
        <a href="<c:url value='/'/>">Voltar</a>
    </body>
</html>
