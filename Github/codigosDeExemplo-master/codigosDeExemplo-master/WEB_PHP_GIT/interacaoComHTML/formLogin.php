<html>
	<head>
		<title>Login</title>
	</head>
	<body>
	  <form action="formLogin.php" method="post">
		Login:
		<input type="text" name="txtLogin" pattern="[a-z A-Z]*" required />
		<br><br>
		Senha:
		<input type="password" name="txtSenha" required/>
		<br><br>
		<input type="submit" value="Enviar" />
	  </form>
	</body>
</html>

<?php

	if(isset($_POST) && !empty($_POST)){
		
		$login = $_POST["txtLogin"];
		$senha = $_POST["txtSenha"];
		
		include("Pessoa.php");
		
		$pessoa = new Pessoa();
		$pessoa->setLogin($login);
		$pessoa->setSenha($senha);
		
		$ok = $pessoa->validarAcesso();
		
		if($ok){
			header("location:formCadPessoa.php");
		}else{
			echo "Acesso Negado!!!";
		}
		
	}

?>