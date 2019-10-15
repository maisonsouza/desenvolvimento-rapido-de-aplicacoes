<?php
	header('Content-Type: text/html; charset=utf-8');
	
	require_once("../connection/FabricaConexao.php");
    $conn = FabricaConexao::conectar();
	
	require_once("../model/bean/Produto.php");
	require_once("../model/dao/ProdutoDAO.php");
	
	$produto = new Produto($_POST["txtId"],
						   $_POST["txtNome"],
						   $_POST["txtValor"]);
	 
	$dao = new ProdutoDAO($conn);
	$alterou = $dao->altera($produto);

	//exibindo msg de sucesso
	if($alterou){
	    echo "<script>
				  alert('Alteração realizada com sucesso')  ;
				  window.open('../view/formConsultaProduto.php', '_self');
			  </script>"    ;
	 }
?>
