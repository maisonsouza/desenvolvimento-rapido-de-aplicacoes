<?php
class Produto
{
	// atributos
	public $nome;

	public $preco;

	// métodos
	public function calcularDesconto($percentualDesconto)
	{
		return $this->preco * $percentualDesconto/100;
	}
}
?>

