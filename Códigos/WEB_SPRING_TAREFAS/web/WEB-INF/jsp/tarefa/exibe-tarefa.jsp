<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
    <body>
        <h3>Alterar tarefa - ${tarefa.id}</h3>
        <form action="<c:url value='/alteraTarefa'/>" method="post">
            <input type="hidden" name="id" value="${tarefa.id}" />
            Descrição:
            <br><form:errors path="tarefa.descricao" cssStyle="color:red"/> <br>
            <textarea name="descricao" cols="50" rows="5">${tarefa.descricao}</textarea>
            <br>
            Finalizado? 
            <input type="checkbox" name="finalizado"
            value="true" ${tarefa.finalizado?'checked':''}/>
            Em: 
            <form:errors path="tarefa.dataFinalizacao" cssStyle="color:red"/>           
            <fmt:formatDate var="fmtDate" value="${tarefa.dataFinalizacao.time}" 
                            pattern="yyyy-MM-dd"/>
            <input type="date" name="dataFinalizacao" value="${fmtDate}" >
            <br><br>
            <input type="submit" value="Alterar"/>
            <br><br>            
        </form>
        <a href="<c:url value='/index'/>">Voltar</a>
    </body>
</html>