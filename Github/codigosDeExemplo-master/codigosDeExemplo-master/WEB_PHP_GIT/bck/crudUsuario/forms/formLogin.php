<html>
   <head>
         <title>Formul�rio de Cadastro de Usu�rios</title>
   </head>
   <body>
         <form action="../actions/validaLogin.php" method="post">
               <table align="center"  border="1" >
                      <tr><th colspan=2>Formul�rio de Login</th></tr>
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

