<?php include("../actions/verificaSessaoUsuario.php")?>
<html>
   <head>
         <title>Formulário de Cadastro de Usuários</title>
   </head>
   <body>
         <form action="../actions/cadUsuario.php" method="post">
               <table align="center"  border="1" >
                      <tr><th colspan=2>Formulário de Cadastro de Usuários</th></tr>
                      <tr>
                           <td>Nome</td>
                           <td><input type="text" name="txtNome"></td>
                      </tr>
                      <tr>
                           <td>Login</td>
                           <td><input type="text" name="txtLogin"></td>
                      </tr>
                      <tr>
                           <td>Senha</td>
                           <td><input type="password" name="txtSenha"></td>
                      </tr>
                      <tr>
                           <td colspan=2 align=center>
                               <input type="submit" value="Enviar">
                               <input type="reset" value="Limpar">
                           </td>
                      </tr>
               </table>
         </form>
   </body>
</html>

