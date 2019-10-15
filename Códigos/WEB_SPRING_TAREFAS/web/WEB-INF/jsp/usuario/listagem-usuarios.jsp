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
                <th>Login</th>
                <th>Photo</th>
            </tr>
            <c:forEach items="${listaUsuarios}" var="usuario">
            <tr>
                <td>${usuario.id}</td>                
                <td>${usuario.login}</td> 
                        <img  />

                <td><img class="photo" src="data:image/jpg;base64,${usuario.photo}"  /></td>                
            </tr>
            </c:forEach>
        </table>        
    </body>
</html>