<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
    <body>
        <h1>Formulário de Adição de Tarefas</h1>
        <form action="<c:url value='/adicionaTarefa'/>" method="post">            
            <fmt:message key="tarefa.descricao" />
            <br>
            <textarea name="descricao" rows="5" cols="100" ></textarea>
            <br>
            <form:errors path="tarefa.descricao" cssStyle="color:red"/>
            <br>
            <input type="submit" value="Adicionar">
            <br>        
        </form>
        <br>
        <a href="<c:url value='/index'/>">Voltar</a>
    </body>
</html>
