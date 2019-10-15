<?php

	echo "<br><br> Exercício 1: ";
	function calcularIdade($anoNascimento){
		return date("Y") - $anoNascimento;
	}	
	echo "Idade: " . calcularIdade(1916);
	
	echo "<br><br> Exercício 2: ";
	$nome = "Joyce Miranda dos Santos";
	$partesNome = explode(" " , $nome);
	$ultimoIndice = count($partesNome) - 1;
	echo $partesNome[0] . " " . $partesNome[$ultimoIndice];
	
	echo "<br><br> Exercício 3: ";
	$data = "13/10/2016";
	$dia  = substr($data, 0, 2);
	$mes  = substr($data, 3, 2);
	$ano  = substr($data, 6, 4);
	echo " Dia: " . $dia  ;
	echo " Mês: " . $mes  ;
	echo " Ano: " . $ano  ;
	
	 
	echo "<br><br> Exercício 4: ";
	$carrinho = array("radio", "tv", "geladeira", "tv");
	print_r($carrinho);
	$freqProdutos = array_count_values($carrinho);
	$maiorFreq = 0;
	$produtoMaiorFreq = "";
	foreach($freqProdutos as $key => $value){
		if($value > $maiorFreq){
			$maiorFreq = $value;
			$produtoMaiorFreq = $key;
		}
	}
	echo "Mais Frequente: " . $produtoMaiorFreq . " : " . $maiorFreq ;

?>
