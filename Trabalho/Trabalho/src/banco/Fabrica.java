package banco;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Fabrica {
       private static EntityManagerFactory fabrica;
    
    public static EntityManagerFactory get(){
        if(fabrica==null){
            fabrica = Persistence.createEntityManagerFactory("TrabalhoPU");
        }
        return fabrica;
    }
}