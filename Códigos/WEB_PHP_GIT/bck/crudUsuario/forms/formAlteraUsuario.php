<?php 
	require_once("../dao/usuariodao.php");
	
	$idUsuario = $_GET["idUsuario"];		
	$dao = new UsuarioDAO();
	$usuario = $dao->consultaUsuarioById($idUsuario);
?>
<html>
	<body>
	 <form action="../actions/alteraUsuario.php" method="post">
	   <input type="hidden" name="txtIdUsuario" value="<?=$usuario['idusuario']?>">
	   <table align="center"  border="1" >
			<tr><th colspan=2>Formulário de Alteração de Usuários</th></tr>
			<tr><td>Nome</td>
				<td><input type="text" name="txtNome" value="<?=$usuario['nome']?>"></td>
			</tr>
			<tr><td>Login</td>
				<td><input type="text" name="txtLogin" value="<?=$usuario['login']?>"></td>
			</tr>
			<tr><td>Senha</td>
				<td><input type="password" name="txtSenha" value="<?=$usuario['senha']?>"></td>
			</tr>
			<tr><td colspan=2> <input type="submit" value="Alterar"></td></tr>
	   </table>
	 </form>
	</body>
</html>
