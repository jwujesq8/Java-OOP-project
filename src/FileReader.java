import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Map;

public class FileReader {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\zhuko\\IdeaProjects\\projekt\\biblioteczka.bin");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Biblioteczka biblioteczka = (Biblioteczka) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();




        System.out.println("Cała biblioteczka: ");
        for(Map.Entry<Integer, Ksiazki> entry:biblioteczka.getBiblioteczka().entrySet()){
            Ksiazki ksiazka = entry.getValue();
            System.out.println("\t" + entry.getKey() + ". " + ksiazka.getTytul() + " " + ksiazka.getAutor());
        }

        }


}
