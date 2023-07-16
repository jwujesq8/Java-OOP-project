import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Biblioteczka implements Serializable {
    private Map<Integer, Ksiazki> biblioteczka = new HashMap<>();

    

    public Map<Integer, Ksiazki> getBiblioteczka(){
        return biblioteczka;
    }


}
