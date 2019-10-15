	<?php
	class conexaobd{

		static function conectar(){

			$host = "localhost";
			$dbname = "sysControleAcademico";
			$user = "root";
			$password = "";
			
			try{
				$conn = new PDO("mysql:host=$host;dbname=$dbname", 
								$user, $password);
				$conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
				return $conn;
			}catch(Exception $e){
				echo "Erro de conexão com BD - bd.php " . $e->getMessage();
			}
		}
	}
	

	?>	


