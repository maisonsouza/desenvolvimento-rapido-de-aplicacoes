<?php
require_once("../bd/conexaobd.php");
class UsuarioDao{
	
	public $conn;
	
	function UsuarioDao(){
		$this->conn = conexaobd::conectar();
	}
	
	function cadastraUsuario($usuario){
		try{
		 $sql = "INSERT INTO USUARIO VALUES (0, ?, ?, ?)";
		 $stmt = $this->conn->prepare($sql);
		 $stmt->bindValue(1, $usuario->nome);
		 $stmt->bindValue(2, $usuario->login);
		 $stmt->bindValue(3, $usuario->senha);
		 return $stmt->execute();
		}catch(Exception $e){
			echo $e->getMessage();
		}
	}
	
	/** continua **/
	
	function consultaUsuarioByID($id){
		try{					
			 $sql = "SELECT * FROM USUARIO WHERE idUsuario=? ";
			 $stmt = $this->conn->prepare($sql);
			 $stmt->bindValue(1, $id); 
			 $stmt->execute();
			 return $stmt->fetch();	 
		}catch(Exception $e){
			echo $e->getMessage();
		}
	}
	
	function consultaUsuarioByName($nome){
		try{					
			 $sql = "SELECT * FROM USUARIO WHERE nome LIKE ? ORDER BY nome ";
			 $stmt = $this->conn->prepare($sql);
			 $stmt->bindValue(1, "%$nome%"); 
			 $stmt->execute();
			 return $stmt;	 
		}catch(Exception $e){
			echo $e->getMessage();
		}
	}
	
	function alteraUsuario($usuario){
		try{
		 $sql = "UPDATE USUARIO SET nome=?, login=?, senha=? WHERE idUsuario=? ";
		 $stmt = $this->conn->prepare($sql);
		 $stmt->bindValue(1, $usuario->nome);
		 $stmt->bindValue(2, $usuario->login);
		 $stmt->bindValue(3, $usuario->senha);
		 $stmt->bindValue(4, $usuario->idUsuario);
		 return $stmt->execute();
		}catch(Exception $e){
			echo $e->getMessage();
		}		 
	}
	
	function excluiUsuario($idUsuario){
		try{
		 $sql = "DELETE FROM USUARIO WHERE idUsuario=? ";
		 $stmt = $this->conn->prepare($sql);
		 $stmt->bindValue(1, $idUsuario);
		 return $stmt->execute();
		}catch(Exception $e){
			echo $e->getMessage();
		}		 
	}
	
	function validaLogin($login, $senha){
		try{
		 $sql = "SELECT * FROM USUARIO WHERE login=? and senha=? ";
			 $stmt = $this->conn->prepare($sql);
			 $stmt->bindValue(1, $login); 
			 $stmt->bindValue(2, $senha); 
			 $stmt->execute();
			 if($stmt->fetch()) 
				 return true;	
		}catch(Exception $e){
			echo $e->getMessage();
		}		 
	}
}

?>