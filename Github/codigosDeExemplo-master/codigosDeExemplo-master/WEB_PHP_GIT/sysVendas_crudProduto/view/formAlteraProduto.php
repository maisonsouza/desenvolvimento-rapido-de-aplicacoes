<?php 
	require_once("../connection/FabricaConexao.php");
    $conn = FabricaConexao::conectar();
	
	require_once("../model/dao/ProdutoDAO.php");
	
	$id = $_GET["id"];		
	$dao = new ProdutoDAO($conn);
	$produto = $dao->consultaById($id);
?>
<html>
	<body>
	 <form action="../controller/alteraProduto.php" method="post">
	   <input type="hidden" name="txtId" value="<?=$produto['id']?>">
	   <table align="center"  border="1" >
			<tr><th colspan=2>Formulário de Alteração de Produto</th></tr>
			<tr><td>Nome</td>
				<td><input type="text" name="txtNome" value="<?=$produto['nome']?>"></td>
			</tr>
			<tr><td>Valor</td>
				<td><input type="text" name="txtValor" value="<?=$produto['valor']?>"></td>
			</tr>
			<tr><td colspan=2> <input type="submit" value="Alterar"></td></tr>
	   </table>
	   <a href="../index.php">Voltar</a>
	 </form>
	</body>
</html>