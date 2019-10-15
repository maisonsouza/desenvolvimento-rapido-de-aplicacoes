<html>
	<head>
		<title>Cadastro Pessoa</title>
	</head>
	<body>
	  <form action="processa.php" method="post">
		Nome:
		<input type="text" name="txtNome" pattern="[a-z A-Z]*" required />
		<br><br>
		Ano Nascimento:
		<input type="date" name="txtDataNascimento" required/>
		<br><br>
		<input type="submit" value="Enviar" />
	  </form>
	</body>
</html>