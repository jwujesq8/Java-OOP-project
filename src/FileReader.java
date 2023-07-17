import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Map;

public class FileReader {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\zhuko\\IdeaProjects\\projekt\\biblioteczka.bin");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Library library = (Library) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();




        System.out.println("Cała biblioteczka: ");
        for(Map.Entry<Integer, Ksiazki> entry:library.getLibrary().entrySet()){
            Ksiazki book = entry.getValue();
            System.out.println("\t" + entry.getKey() + ". " + book.getTytul() + " " + book.getAutor());
        }

        }


}
