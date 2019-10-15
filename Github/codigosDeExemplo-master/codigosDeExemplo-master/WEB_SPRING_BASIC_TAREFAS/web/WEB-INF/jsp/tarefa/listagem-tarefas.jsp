<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
    <head>
        <meta charset="utf-8"/>
        <script type="text/javascript" src="resources/js/jquery.js"></script>
        <script type="text/javascript" src="resources/js/default.js"></script>
        <link rel="stylesheet" href="<c:url value='/resources/css/default.css'/>" 
    </head>
    <body>
        
        
        <a href="<c:url value='/index'/>">Voltar</a> <br><br>
        <table>
            <tr>
                <th>Id</th>
                <th>Descrição</th>
                <th>Finalizada?</th>
                <th>Data de Finalização</th>
                <th>Ação</th>
            </tr>
            <c:forEach items="${listaTarefas}" var="tarefa">
            <tr>
                <td>${tarefa.id}</td>
                <td>${tarefa.descricao}</td>
                <c:if test="${tarefa.finalizado eq true}">
                <td>Finalizada</td>
                </c:if>
                <c:if test="${tarefa.finalizado eq false}">
                <td id="tarefa_${tarefa.id}">
                     Não finalizada <br>
                     <a href="#" onclick="finalizaAgora(${tarefa.id})"> Finalizar agora? </a>
                </td>
                </c:if>
                <td id="tarefa_data_${tarefa.id}">
                    <fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy"/>
                </td>
                <td>
                    <a href="exibeTarefa?id=${tarefa.id}"> Alterar </a> 
                    &nbsp;
                    <a href="removeTarefa?id=${tarefa.id}" 
                       onclick="return confirm('Deseja realmente excluir?')" > Remover </a> 
                </td>
            </tr>
            </c:forEach>
        </table>        
    </body>
</html>