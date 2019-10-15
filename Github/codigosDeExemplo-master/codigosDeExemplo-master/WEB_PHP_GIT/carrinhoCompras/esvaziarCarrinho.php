<?php
     session_start();

     //exclui os produtos do carrinho
     unset($_SESSION["carrinho"]);
     
     header("location:index.php") ;

?>

