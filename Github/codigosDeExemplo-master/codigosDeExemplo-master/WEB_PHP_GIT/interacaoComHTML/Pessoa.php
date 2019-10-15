<?php

	class Pessoa{
		
		private $nome;
		private $login;
		private $senha;
		private $dataNascimento;
		
		public function validarAcesso(){
			if($this->login == "adm" && $this->senha == "123"){
				return true;
			}else{
				return false;
			}
		}
		
		public function setNome($nome){
			$this->nome = $nome;
		}
				
		public function getNome(){
			return $this->nome;
		}
		
		public function setLogin($login){
			$this->login = $login;
		}
				
		public function getLogin(){
			return $this->login;
		}
		
		public function setSenha($senha){
			$this->senha = $senha;
		}
				
		public function getSenha(){
			return $this->senha;
		}
		
		public function setDataNascimento($dataNascimento){
			$this->dataNascimento = $dataNascimento;
		}
				
		public function getDataNascimento(){
			return $this->dataNascimento;
		}
		
		public function calcularIdade($anoAtual){
			$anoNascimento = date("Y", strtotime($this->dataNascimento));
			return $anoAtual - $anoNascimento;
		}
		
		
	}

?>