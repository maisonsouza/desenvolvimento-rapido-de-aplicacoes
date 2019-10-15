package dra_jpa_hibernate.relacionamento.ManyToMany;

import java.util.ArrayList;
import java.util.Collection;
import jpa.basics.daogenerico.*;
import jpa.basics.connectionfactory.ConnectionFactory;

public class TesteGenericDAO {
    public static void main(String[] args) {
        
            //insercao
            
            GenericDAO<Autor> autorDAO = 
                    new GenericDAO<>
                        (ConnectionFactory.getEntityManager());
            
            Autor a = new Autor("Fulano"); //1L
            autorDAO.save(a);
            Autor b = new Autor("Ciclano");//2L
            autorDAO.save(b);
            
            GenericDAO<Livro> livroDAO = 
                    new GenericDAO<>
                        (ConnectionFactory.getEntityManager());


            Collection<Autor> autores = new ArrayList<>();
            autores.add(a);
            autores.add(b);

            Livro livro = new Livro("XYZ", autores);

            livroDAO.save(livro);
             
            a = autorDAO.findById(Autor.class, a.getId());
            b = autorDAO.findById(Autor.class, b.getId());
            
            autores = new ArrayList<>();
            autores.add(a);
            autores.add(b);
            
            livro = new Livro("ABC", autores);
            
            livroDAO.update(livro);
            
            Autor autor = autorDAO.findById(Autor.class, a.getId());
            autorDAO.refresh(autor);
            System.out.println("Autor: " + autor.getNome() + "\n**Livros: ");
            Collection<Livro> livros = autor.getLivros();
            livros.forEach((livro1) -> {
                System.out.println("-"+livro1.getNome());
            });
            
            ConnectionFactory.closeEntityFactory();
        

       
            
        
        
        
        
    }
}
