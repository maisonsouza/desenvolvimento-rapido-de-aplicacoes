<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${message}</h1>
        <a href="${pageContext.request.contextPath}/formAddTarefa">Adicionar Tarefa</a>
        <a href="${pageContext.request.contextPath}/listaTarefas">Listar Tarefa</a>
    </body>
</html>
