import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Library implements Serializable {
    private Map<Integer, Ksiazki> library = new HashMap<>();



    public Map<Integer, Ksiazki> getLibrary(){
        return library;
    }


}
