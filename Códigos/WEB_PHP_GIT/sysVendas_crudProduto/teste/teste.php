<?php

   require_once("../connection/FabricaConexao.php");
   $conn = FabricaConexao::conectar();
   
   require_once("../model/bean/Produto.php");
   $produto = new Produto("SOM", 500.00);
    
   require_once("../model/dao/ProdutoDAO.php");	
   $dao = new ProdutoDAO($conn);
   $dao->cadastrar($produto);

   

?>