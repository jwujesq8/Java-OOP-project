import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library implements Serializable {
    private List<Ksiazki> library;
    private List<Czytane> readingList;
    private List<Przeczytane> readList;
    private List<Kupic> buyList;

    public void categorizeLibrary(){
        for(Ksiazki book: library){

        }
    }
    public Library(List<Ksiazki> libraryData){
        this.library = libraryData;
        categorizeLibrary();
    }
    public Library(){}



    public List<Ksiazki> getLibrary(){
        return library;
    }
    public void addBook(Ksiazki newBook){
        library.add(newBook);
    }

    public int getSize(){ return library.size();}

    public void printLibrary(){
        int i = 0;
        for(Ksiazki book:library){
            System.out.println("\t(" + i + ") " + book.getTytul() + ", " + book.getAutor());
            i++;
        }
    }


}
