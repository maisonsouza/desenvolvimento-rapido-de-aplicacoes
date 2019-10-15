function finalizaAgora(id) {
    $.post("finalizaTarefa", {'id' : id}, function(dadosDeResposta) {
        // selecionando o elemento html através da
        // ID e alterando o HTML dele
        $("#tarefa_"+id).html("Finalizado");
        $("#tarefa_data_"+id).html(dadosDeResposta);
    });
}

