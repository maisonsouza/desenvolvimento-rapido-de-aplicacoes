<html>
   <head>
         <title>Formul�rio de Consulta de Usu�rios</title>		 
		 <link rel="stylesheet" href="../css/css.css">
		 <script src="../js/js.js"></script>
   </head>
   <body>
         <form action="formConsultaUsuario.php" method="post">
            <table align="center"  border="1" >
                <tr>
					<th colspan="2">Formul�rio de Consulta de Usu�rios</th>
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
		 <?php include("../actions/consultaUsuario.php") ?>
   </body>
</html>
