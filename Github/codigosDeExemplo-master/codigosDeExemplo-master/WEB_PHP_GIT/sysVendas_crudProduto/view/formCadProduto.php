<html>
   <head>
         <title>Formulário de Cadastro de Produto</title>
   </head>
   <body>
         <form action="../controller/cadProduto.php" method="post">
               <table align="center"  border="1" >
                      <tr><th colspan=2>Formulário de Cadastro de Produto</th></tr>
                      <tr>
                           <td>Nome</td>
                           <td><input type="text" name="txtNome"></td>
                      </tr>
                      <tr>
                           <td>Valor</td>
                           <td><input type="number" name="txtValor"></td>
                      </tr>                      
                      <tr>
                           <td colspan=2 align=center>
                               <input type="submit" value="Enviar">
                               <input type="reset" value="Limpar">
                           </td>
                      </tr>
               </table>
			   <a href="../index.php">Voltar</a>
         </form>
   </body>
</html>