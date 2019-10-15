<?php
	require_once("../dao/usuariodao.php");
	session_start();
	$login = $_POST["txtLogin"];
	$senha = $_POST["txtSenha"];
	 
	$dao = new UsuarioDAO();
	$loginCorreto = $dao->validaLogin($login, $senha);


	if($loginCorreto){
	    $_SESSION["logado"] = true;
		header("location:../forms/formCadUsuario.php");
	}else{
		session_destroy();
		echo "<script>
				  alert('Dados incorretos!')  ;
				  window.open('../forms/formLogin.php', '_self');
			  </script>"    ;
	 
	}	
?>


