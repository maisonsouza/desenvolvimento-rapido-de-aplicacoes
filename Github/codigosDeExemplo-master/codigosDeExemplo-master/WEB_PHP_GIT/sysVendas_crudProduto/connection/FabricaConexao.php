<?php
	class FabricaConexao{
	 static function conectar(){
		$host = "localhost";
		$dbname = "sysVendas";
		$user = "root";
		$password = "";
			
		$conn = new PDO("mysql:host=$host;dbname=$dbname", 
						$user, $password);
								
		return $conn;		
	 }
	}	
?>	


