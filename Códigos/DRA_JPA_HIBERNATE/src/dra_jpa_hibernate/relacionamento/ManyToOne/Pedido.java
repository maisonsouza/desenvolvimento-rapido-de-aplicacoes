package dra_jpa_hibernate.relacionamento.ManyToOne;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pedido {

    @Id @GeneratedValue
    private long id;    
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Cliente cliente;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
    
}
