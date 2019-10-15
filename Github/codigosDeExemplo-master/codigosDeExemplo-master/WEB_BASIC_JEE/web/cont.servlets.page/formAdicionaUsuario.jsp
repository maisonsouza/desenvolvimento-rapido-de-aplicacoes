<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <body>
        <form method="post"
              action="${pageContext.request.contextPath}/adicionaUsuario" >
            Email: <input type="text" name="email">
            <br><br>
            Senha: <input type="password" name="senha">
            <br><br>
            <input type="submit" value="Adicionar">
        </form>
    </body>
</html>
