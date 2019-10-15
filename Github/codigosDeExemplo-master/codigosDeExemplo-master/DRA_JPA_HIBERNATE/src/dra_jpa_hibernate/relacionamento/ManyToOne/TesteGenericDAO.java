package dra_jpa_hibernate.relacionamento.ManyToOne;

import jpa.basics.daogenerico.*;
import jpa.basics.connectionfactory.ConnectionFactory;

public class TesteGenericDAO {
    public static void main(String[] args) {
        
        GenericDAO<Pedido> pedidoDAO = 
                new GenericDAO<>
                    (ConnectionFactory.getEntityManager());
        
        Cliente cliente = new Cliente("Joyce");
        
        Pedido pedido = new Pedido(cliente);
        pedidoDAO.save(pedido);
        
        ConnectionFactory.closeEntityFactory();
        
        
    }
}
