<?php
     session_start();

     //verifica se a sessao de carrinho foi iniciada
     if(isset($_SESSION["carrinho"])) {

        echo "<center><b>Produtos do Carrinho: </b>";

        //recupera qtde de produtos
        $qtdeProdutosCarrinho = sizeof($_SESSION["carrinho"]);

        //percorre carrinho e recupera produtos
        for($i=0; $i < $qtdeProdutosCarrinho; $i++){
          echo "<br>".$_SESSION["carrinho"][$i] ;
        }
        
     }else{
        echo "<center><b>Não existem produtos no carrinho..    </b>";
     }
     


?>
     <br>
     <input type="button" value="Voltar" onclick="javaScript:history.back()">

