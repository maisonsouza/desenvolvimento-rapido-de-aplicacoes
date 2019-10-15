<?php
	
	include("Pessoa.php");
	
	$pessoa = new Pessoa();
	
	$pessoa->setNome("Fulano");
	
	$pessoa->setDataNascimento("29-10-2000");
	
	echo "Nome: " . $pessoa->getNome();
	echo "<br>";
	echo "Data Nascimento: " . $pessoa->getDataNascimento();

	$anoAtual = date("Y");
	
	echo "<br>";
	echo "Idade: " . $pessoa->calcularIdade($anoAtual);
	echo "<br>";
	
	
?>