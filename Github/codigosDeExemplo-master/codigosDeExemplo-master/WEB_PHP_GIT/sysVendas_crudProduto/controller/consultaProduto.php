<?php
	require_once("../connection/FabricaConexao.php");
    $conn = FabricaConexao::conectar();
	
	require_once("../model/dao/ProdutoDAO.php");
	
	$nome = isset($_POST["txtNome"])?$_POST["txtNome"]:"";		
	$dao = new ProdutoDAO($conn);
	$registros = $dao->consultaByNome($nome);
	
	showTable($registros);
	
	function showTable($stmt){
		 echo "<table>";
		 echo "<tr><td>Nome</td><td>Nome</td><td>Ação</td></tr>";
		 foreach($stmt as $usr){
			echo "<tr>";
			echo "<td>".$usr["nome"]."</td>";
			echo "<td>".$usr["valor"]."</td>";
			echo "<td>";
			echo "<a href='../view/formAlteraProduto.php?".
			     "id=".$usr['id']."' >Alterar</a>&nbsp;";
			echo "<a href='../controller/excluiProduto.php?".
			     "id=".$usr['id']."' ".
				 "onclick='confirmaExclusao()'>Excluir</a>";
			echo "</td>";
			echo "<tr>";
		 }
		 echo "</table>";	
	}
?>