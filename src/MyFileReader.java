import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Map;

public class MyFileReader {
    public String file;

    public MyFileReader(String fileName) {this.file = fileName;}
    public Library getContent() throws Exception {
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Library library = (Library) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return library;

        }


}
