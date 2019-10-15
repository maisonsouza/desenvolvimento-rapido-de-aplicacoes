<?php

    require_once("../connection/FabricaConexao.php");
    $conn = FabricaConexao::conectar();
	
	require_once("../model/bean/Produto.php");
	require_once("../model/dao/ProdutoDAO.php");
	   
	$produto = new Produto(0,
						   $_POST["txtNome"], 
						   $_POST["txtValor"]);
	 
	$dao = new ProdutoDAO($conn);
	$inseriu = $dao->cadastrar($produto);
	//exibindo msg de sucesso
	if($inseriu){
	    echo "<script>
				  alert('Cadastro realizado com sucesso')  ;
				  window.open('../view/formCadProduto.php', '_self');
			  </script>"    ;
	 }	
?>