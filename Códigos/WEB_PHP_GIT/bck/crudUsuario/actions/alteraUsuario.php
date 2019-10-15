<?php
	header('Content-Type: text/html; charset=utf-8');
	require_once("../classes/usuario.php");
	require_once("../dao/usuariodao.php");
	
	$usuario = new Usuario();
	
	$usuario->idUsuario     = $_POST["txtIdUsuario"];	
	$usuario->nome  	= $_POST["txtNome"];
	$usuario->login 	= $_POST["txtLogin"];
	$usuario->senha 	= $_POST["txtSenha"];
	 
	$dao = new UsuarioDAO();
	$alterou = $dao->alteraUsuario($usuario);

	//exibindo msg de sucesso
	if($alterou){
	    echo "<script>
				  alert('Alteração realizada com sucesso')  ;
				  window.open('../forms/formConsultaUsuario.php', '_self');
			  </script>"    ;
	 }
?>
