<?php
    
    include("Quadrado.php");
    
    $quad = new Quadrado(10.0);
        
    echo " A área do Quadrado de lado " . $quad->getLado().
         " é " . $quad->calculaArea();

?>