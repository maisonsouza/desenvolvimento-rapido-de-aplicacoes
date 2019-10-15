<?php
     session_start();
     $codProduto = $_GET["codProduto"];
     
     //verifica se a sessao de carrinho nao foi iniciada
     if(!isset($_SESSION["carrinho"])) {
         //adicionat primeiro produto
         $_SESSION["carrinho"][0] = $codProduto;
     }else{
         //recupera qtde de produtos
         $qtdeProdutosCarrinho = sizeof($_SESSION["carrinho"]);
         //adiciona produto na proxima posicao do carrinho disponivel
         $_SESSION["carrinho"][$qtdeProdutosCarrinho] = $codProduto;
     }
     
     //redireciona para a pagina principal
     header("location:index.php") ;

?>

