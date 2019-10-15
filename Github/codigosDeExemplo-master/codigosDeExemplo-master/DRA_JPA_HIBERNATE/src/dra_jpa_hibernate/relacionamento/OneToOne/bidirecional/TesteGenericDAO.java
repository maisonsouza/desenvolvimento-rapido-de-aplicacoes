package dra_jpa_hibernate.relacionamento.OneToOne.bidirecional;

import jpa.basics.daogenerico.*;
import jpa.basics.connectionfactory.ConnectionFactory;

public class TesteGenericDAO {
    public static void main(String[] args) {
        
        try{
            
            Governador_Bidirecional governador = new Governador_Bidirecional("Fulaninho");
        
            GenericDAO<Estado_Bidirecional> estadoDAO = 
                    new GenericDAO<>
                        (ConnectionFactory.getEntityManager());

            Estado_Bidirecional estado = 
                    new Estado_Bidirecional("Amazonas", governador);
            estadoDAO.save(estado);

            System.out.println("- Governador : " + estado.getGovernador().getNome());

            GenericDAO<Governador_Bidirecional> govDAO = 
                    new GenericDAO<>
                        (ConnectionFactory.getEntityManager());

            governador = govDAO.findById(Governador_Bidirecional.class, 1L);
            System.out.println("- Estado : " + governador.getEstado().getNome());

        }finally{
             ConnectionFactory.closeEntityFactory();
        }
        
       
        
        
    }
}
