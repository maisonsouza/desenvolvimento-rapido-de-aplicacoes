<?php

	class ProdutoDAO{
		
		private $conn;
		
		public function __construct($conn){
			$this->conn = $conn;
		}
		
		public function cadastrar($produto){
			$sql = "INSERT INTO produto VALUES (0,?,?)";
			$stmt = $this->conn->prepare($sql);
			$stmt->bindValue(1, $produto->getNome());
			$stmt->bindValue(2, $produto->getValor());
			return $stmt->execute();			
		}
	}	
		function consultaByNome($nome){	
		 $sql = "SELECT * FROM produto WHERE nome LIKE ? ORDER BY nome ";
		 $stmt = $this->conn->prepare($sql);
		 $stmt->bindValue(1, "%$nome%"); 
		 $stmt->execute();
		 return $stmt;	 
		}
		
		function exclui($id){
		 $sql = "DELETE FROM produto WHERE id=? ";
		 $stmt = $this->conn->prepare($sql);
		 $stmt->bindValue(1, $id);
		 return $stmt->execute();
		}
		
		function consultaByID($id){
		 $sql = "SELECT * FROM produto WHERE id=? ";
		 $stmt = $this->conn->prepare($sql);
		 $stmt->bindValue(1, $id); 
		 $stmt->execute();
		 return $stmt->fetch();	 
		}
		
		function altera($produto){
		
		 $sql = "UPDATE produto SET nome=?, valor=? WHERE id=? ";
		 $stmt = $this->conn->prepare($sql);
		 $stmt->bindValue(1, $produto->getNome());
		 $stmt->bindValue(2, $produto->getValor());
		 $stmt->bindValue(3, $produto->getId());
		 return $stmt->execute();
				 
		}
		
	}



?>