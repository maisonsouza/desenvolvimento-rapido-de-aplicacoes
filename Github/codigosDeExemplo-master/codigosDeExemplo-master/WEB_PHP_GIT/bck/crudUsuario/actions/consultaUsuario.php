<?php
	require_once("../dao/usuariodao.php");

	$nome = isset($_POST["txtNome"])?$_POST["txtNome"]:"";		
	$dao = new UsuarioDAO();
	$registros = $dao->consultaUsuarioByName($nome);
	
	montaTabelaUsuarios($registros);
	
	function montaTabelaUsuarios($stmt){
		 echo "<table>";
		 echo "<tr><td>Nome</td><td>Login</td><td>Ação</td></tr>";
		 foreach($stmt as $usr){
			echo "<tr>";
			echo "<td>".$usr["nome"]."</td>";
			echo "<td>".$usr["login"]."</td>";
			echo "<td>";
			echo "<a href='../forms/formAlteraUsuario.php?".
			     "idUsuario=".$usr['idusuario']."' >Alterar</a>&nbsp;";
			echo "<a href='../actions/excluiUsuario.php?".
			     "idUsuario=".$usr['idusuario']."' ".
				 "onclick='return confirmaExclusao()'>Excluir</a>";
			echo "</td>";
			echo "<tr>";
		 }
		 echo "</table>";	
	}
?>
