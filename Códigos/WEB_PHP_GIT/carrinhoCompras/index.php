<html>
  <head>
        <title>Página de Compras</title>
  </head>
  
  <body>
        <br>
        <center>
        <?php
             session_start();
             //verifica se a sessao de carrinho foi iniciada
             if(isset($_SESSION["carrinho"])) {
               //recupera a qtde de produtos do carrinho
               $qtdeProdutosCarrinho = sizeof($_SESSION["carrinho"]);
               echo "Total de Produtos no carrinho: $qtdeProdutosCarrinho ";
             }
        ?>
        </center>
        <br>
        <table border="1" align="center">
               <tr align="center">
                   <td>
                       <img src="produto2.jpg" width="150" height="150">
                       <br>
                       <b>Rio</b>
                   </td>
                   <td>
                       <a href="adicionaProdutoCarrinho.php?codProduto=Rio">Adicionar</a>
                   </td>
               </tr>
               <tr align="center">
                   <td>
                       <img src="produto3.jpg" width="150" height="150">
                       <br>
                       <b>Galinha Pintadinha</b>
                   </td>
                   <td>
                       <a href="adicionaProdutoCarrinho.php?codProduto=Galinha Pintadinha">Adicionar</a>
                   </td>
               </tr>
        </table>
        <br>
        <center>
                 <a href="finalizarCompra.php">Finalizar Compra</a>
                 <a href="esvaziarCarrinho.php">Esvaziar Carrinho</a>
        </center>
  
  
  </body>

</html>
