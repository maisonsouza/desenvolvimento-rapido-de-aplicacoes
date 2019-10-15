<html>
   <head>
         <title>Formulário de Consulta de Produtos</title>		 
		 <link rel="stylesheet" href="../css/css.css">
		 <script src="../js/js.js"></script>
   </head>
   <body>
         <form action="formConsultaProduto.php" method="post">
            <table align="center"  border="1" >
                <tr>
					<th colspan="2">Formulário de Consulta de Produtos</th>
				</tr>
                <tr>
                    <td>
						Nome:
						<input type="text" name="txtNome">
						<input type="submit" value="Buscar">
                    </td>
                </tr>
            </table>			
         </form>
		 <?php include("../controller/consultaProduto.php") ?>
		 <a href="../index.php">Voltar</a>

   </body>
</html>