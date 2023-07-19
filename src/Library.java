import java.io.Serializable;
import java.util.*;

public class Library implements Serializable {
    private List<Book> library;
    private List<Reading> readingList;
    private List<Read> readList;
    private List<Buy> buyList;
    public Library(){}




    public List<Book> getLibrary(){
        return library;
    }

    public List<Reading> getReadingList(){return readingList;}
    public List<Read> getReadList(){return readList;}

    public List<Buy> getBuyList(){return buyList;}

    public void addBook(Book newBook){
        library.add(newBook);
    }
    public void addReadingList(Reading newReading){
        readingList.add(newReading);
    }
    public void addReadList(Reading readingInfo, Date endDate, boolean like){
        readList.add(new Read(readingInfo, endDate, like));
        readingList.remove(readingInfo);
    }
    public void addReadList(Reading readingInfo, Date endDate){
        readList.add(new Read(readingInfo, endDate));
        readingList.remove(readingInfo);
    }
    public void addBuyList(Buy newBuy){
        buyList.add(newBuy);
    }

    public int getSize(){ return library.size();}

    public void printLibrary(){
        int i = 0;
        for(Book book:library){
            System.out.println("\t(" + i + ") " + book.getTitle() + ", " + book.getAuthor());
            i++;
        }
    }
    public void printReadingList(){
        int i = 0;
        for(Reading reading:readingList){
            Book readingBook = library.get(reading.getBooksId());
            System.out.println("\t(" + i + ") " + readingBook.getTitle() + ", " + readingBook.getAuthor() +
                    "\n\t\tstart: " + reading.getStartDate());
            i++;
        }
    }
    public void printReadList(){
        int i = 0;
        for(Read read:readList){
            Book readBook = library.get(read.getBooksId());
            System.out.println("\t(" + i + ") " + readBook.getTitle() + ", " + readBook.getAuthor() +
                    "\n\t\tstart: " + read.getStartDate() + ", end: " + read.getEndDate());
            i++;
        }
    }
    public void printBuyList(){
        int i = 0;
        for(Buy bookToBuy:buyList){
            System.out.println("\t(" + i + ") " + bookToBuy.getTitle() + ", " + bookToBuy.getAuthor() +
                    ", cover: " + bookToBuy.cover);
            i++;
        }
    }

    public boolean findMatchBookInTheLibrary(String title, String author){
        for(Book book:library){
            if(book.getTitle().equals(title) && book.getAuthor().equals(author)) return true;
        }
        return false;
    }


}
