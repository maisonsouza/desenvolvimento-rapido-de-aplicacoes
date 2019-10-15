<?php
	session_start();

	if(!isset($_SESSION["logado"]) || $_SESSION["logado"] != true ){
		 echo "<script>
				  alert('Você não tem acesso a essa página!')  ;
				  window.open('../forms/formLogin.php', '_self');
			  </script>"    ;
	}


?>