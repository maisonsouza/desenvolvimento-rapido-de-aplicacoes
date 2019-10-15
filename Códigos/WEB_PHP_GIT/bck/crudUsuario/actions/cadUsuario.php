<?php
	require_once("../classes/usuario.php");
	require_once("../dao/usuariodao.php");
	
	$usuario = new Usuario();
	 
	$usuario->nome  = $_POST["txtNome"];
	$usuario->login = $_POST["txtLogin"];
	$usuario->senha = $_POST["txtSenha"];
	 
	$dao = new UsuarioDAO();
	$inseriu = $dao->cadastraUsuario($usuario);

	//exibindo msg de sucesso
	if($inseriu){
	    echo "<script>
				  alert('Cadastro realizado com sucesso')  ;
				  window.open('../forms/formConsultaUsuario.php', '_self');
			  </script>"    ;
	 }	
?>


