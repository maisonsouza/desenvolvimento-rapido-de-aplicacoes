<?php
	header('Content-Type: text/html; charset=utf-8');
	
	require_once("../connection/FabricaConexao.php");
    $conn = FabricaConexao::conectar();
	
	require_once("../model/dao/ProdutoDAO.php");
	
	$id = $_GET["id"];		 
	$dao = new ProdutoDAO($conn);
	$excluiu = $dao->exclui($id);

	
	//exibindo msg de sucesso
	if($excluiu){
	    echo "<script>
				  alert('Exclusão realizada com sucesso')  ;
				  window.open('../view/formConsultaProduto.php', '_self');
			  </script>"    ;
	 }
?>
