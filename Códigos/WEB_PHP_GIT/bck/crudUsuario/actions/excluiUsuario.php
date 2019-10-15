<?php
	header('Content-Type: text/html; charset=utf-8');
	require_once("../classes/usuario.php");
	require_once("../dao/usuariodao.php");
	
	$usuario = new Usuario();
	
	$idUsuario = $_GET["idUsuario"];	
	 
	$dao = new UsuarioDAO();
	$excluiu = $dao->excluiUsuario($idUsuario);

	
	//exibindo msg de sucesso
	if($excluiu){
	    echo "<script>
				  alert('Exclusão realizada com sucesso')  ;
				  window.open('../forms/formConsultaUsuario.php', '_self');
			  </script>"    ;
	 }
?>
