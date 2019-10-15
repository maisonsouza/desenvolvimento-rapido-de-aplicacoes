package mvc.bean;

import java.util.Calendar;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Tarefa {
    
    private Long id;
    
    @NotEmpty(message="{tarefa.descricao.vazia}")
    @Size(min=10, max = 100, message="{tarefa.descricao.limite}")
    private String descricao;
    
    private boolean finalizado;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Calendar dataFinalizacao;

    //...
    
    public Tarefa() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public Calendar getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(Calendar dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }
    
}
