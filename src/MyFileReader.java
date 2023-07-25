import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Map;

public class MyFileReader {
    public String filePath;

    public MyFileReader(String filePath) {this.filePath = filePath;}
    public Library getContent() throws Exception {
        File file = new File(filePath);
        if(!file.exists()) return new Library();

        FileInputStream fileInputStream = new FileInputStream(filePath);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Library library = (Library) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return library;

        }


}
