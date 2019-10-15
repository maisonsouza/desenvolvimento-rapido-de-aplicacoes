<?php

class Quadrado{
    
    private $lado;
    
    //construtor da classe
    function __construct ($lado){
        $this->lado = $lado;
    }
    
    function getLado(){
        return $this->lado;
    }
    
    function setLado($lado){
        $this->lado = $lado;
    }
        
    function calculaArea(){
        return $this->lado * $this->lado;
    }
}
?>