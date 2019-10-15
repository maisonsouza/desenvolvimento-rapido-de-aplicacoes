<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <body>
      <a href="<c:url value='/listaTarefas'/>">Listagem de Tarefas</a>
      <br><br>
      <a href="<c:url value='/menuAdm'/>">Área Administrativa</a>
    </body>
</html>
