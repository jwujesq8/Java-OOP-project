import java.io.Serializable;
import java.util.*;

public class Library implements Serializable {
    private List<Book> library;
    private List<Reading> readingList;
    private List<Read> readList;
    private List<Buy> buyList;
    private List<String> authorsList;
    private List<String> opinionsList;
    public Library(){
        this.library = new ArrayList<>();
        this.readingList = new ArrayList<>();
        this.readList = new ArrayList<>();
        this.buyList = new ArrayList<>();
        this.authorsList = new ArrayList<>();
        this.opinionsList = new ArrayList<>();
    }




    public List<Book> getLibrary(){
        return library;
    }

    public List<Reading> getReadingList(){return readingList;}
    public List<Read> getReadList(){return readList;}

    public List<Buy> getBuyList(){return buyList;}

    public List<String> getOpinionsList(){return opinionsList;}

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

    public void addOpinionsList(String fileName){
        opinionsList.add(fileName);
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
        if(!readingList.isEmpty()){
            int i = 0;
            for(Reading reading:readingList){
                if(reading.getBooksId()<library.size()){
                    Book readingBook = library.get(reading.getBooksId());
                    System.out.println("\t(" + i + ") " + readingBook.getTitle() + ", " + readingBook.getAuthor() + " (" + readingBook.getGenre() + ")" +
                            "\n\t\t\tstart: " + reading.getStartDate());
                    i++;
                } else System.out.println("\t(-) deleted book from the library" +
                        "\n\t\t\tstart: " + reading.getStartDate());
            }
        }
    }
    public void printReadList(){
        int i = 0;
        for(Read read:readList){
            if(read.getBooksId()<library.size()){
                Book readBook = library.get(read.getBooksId());
                System.out.println("\t(" + i + ") " + readBook.getTitle() + ", " + readBook.getAuthor() +
                        "\n\t\t\tstart: " + read.getStartDate() + ", end: " + read.getEndDate());
                i++;
            } else System.out.println("\t(-) deleted book from the library" +
                    "\n\t\t\tstart: " + read.getStartDate() + ", end: " + read.getEndDate());



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

    public void printOpinionsList(){
        int i=0;
        for(String filaName: opinionsList){
            System.out.println("\t(" + i + ") " + filaName);
            i++;
        }
    }

    public Book findBookByTitleAndAuthor(String titleAndAuthor){
        String[] parts = titleAndAuthor.split(", ");
        String title = parts[0];
        String author = parts[1];
        for(Book book:library){
            if(book.getTitle().equals(title) && book.getAuthor().equals(author)) return book;
        }
        return null;
    }

    public boolean findMatchBookInTheLibrary(String title, String author){
        for(Book book:library){
            if(book.getTitle().equals(title) && book.getAuthor().equals(author)) return true;
        }
        return false;
    }

    public void getAuthorsFromTheLibrary(){
        for(Book book: library){
            if(!authorsList.contains(book.author)) authorsList.add(book.author);
        }
    }

    public void printAuthorsList(){
        getAuthorsFromTheLibrary();
        for(String author: authorsList){
            System.out.println("\t" + author);
        }
    }

    public void statisticsHowManyBooksByTheGivenAuthor(String author){
        getAuthorsFromTheLibrary();
        if(authorsList.contains(author)){
            int i=1;
            for(Book book: library){
                if(book.author.equals(author)){
                    System.out.println("\t(" + i + ") title: \"" + book.getTitle() + "\", genre: "  + book.getGenre());
                }
            }
        } else System.out.println("Entered the wrong author (" + author + ")");
    }

    public void howManyTimesHaveYouReadThisParticularBook(int id){
        int howManyTimes = 0;
        for(Read readBook: readList){
            if(readBook.booksId == id) {
                howManyTimes++;
                System.out.println("\t\t("+ howManyTimes + ") " + readBook.getStartDate() + " - " + readBook.getEndDate());
            }
        }
        Book book = library.get(id);
        System.out.println("\tYou've read \"" + book.getTitle() + "\" by " + book.getAuthor() + " " + howManyTimes + " times");
    }
}
