<?php

	include("Pessoa.php");

	$nome = $_POST["txtNome"];
	$dataNascimento = $_POST["txtDataNascimento"];
	
	echo "$nome - $dataNascimento";
	
	$pessoa = new Pessoa();
	$pessoa->setDataNascimento($dataNascimento);
	
	$anoAtual = date("Y");
	
	echo "<br>";
	echo "Idade: " . $pessoa->calcularIdade($anoAtual);
	echo "<br>";
	

?>