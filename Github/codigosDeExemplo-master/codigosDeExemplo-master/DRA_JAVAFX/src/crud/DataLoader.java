package crud;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {
    
    static List<Aniversario> lista ;

    public static List<Aniversario> load(){        
        lista = new ArrayList<>();        
        lista.add(new Aniversario(gerarId(), "fulano"  , LocalDate.now()));
        lista.add(new Aniversario(gerarId(), "beltrano", LocalDate.now()));
        lista.add(new Aniversario(gerarId(), "ciclano" , LocalDate.now()));
        return lista;
    }
    
    public static int gerarId(){
        return (int) Math.round(Math.random() * 100);
    }

    public static boolean addAniversario(Aniversario aniversario){
        lista.add(aniversario);
        return true;
    } 
    
    public static boolean delAniversario(Aniversario aniversario){
        lista.remove(aniversario);
        return true;
    } 
}
