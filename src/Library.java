import java.io.*;
import java.util.*;

public class Library implements Serializable {
    private List<Book> library;
    private List<Reading> readingList;
    private List<Read> readList;
    private List<Buy> buyList;
    private List<String> authorsList;
    private List<String> opinionsList;
    public List<Book> removedBooksFromLibrary;
    public Library(){
        this.library = new ArrayList<>();
        this.readingList = new ArrayList<>();
        this.readList = new ArrayList<>();
        this.buyList = new ArrayList<>();
        this.authorsList = new ArrayList<>();
        this.opinionsList = new ArrayList<>();
        this.removedBooksFromLibrary = new ArrayList<>();
    }

    public void updateAllBooksIdAfterRemovingTheBook(int startId){
        for(int i=startId; i< library.size();i++){
            int pastBooksId = i+1;
            for(Reading reading:readingList) if(reading.getBooksId()==pastBooksId) reading.changeBooksId(i);
            for(Read read: readList) if(read.getBooksId()==pastBooksId) read.changeBooksId(i);
        }
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
    public void removeBook(int id){
        if(id< library.size()){
            Book removedBook = library.get(id);
            removedBooksFromLibrary.add(removedBook);
            int removedBooksId = removedBooksFromLibrary.size()-1;
            int newId = Integer.parseInt("88" + removedBooksId);
            //System.out.println("removed id = " + newId);

            for(Reading reading: readingList){
                if(reading.getBooksId() == id){
                    reading.changeBooksId(newId);
                }
            }
            for(Read read: readList){
                if(read.getBooksId() == id){
                    read.changeBooksId(newId);
                }
            }
            library.remove(id);
            updateAllBooksIdAfterRemovingTheBook(id);
        } else System.out.println("There is no book with this id (" + id + ")");
    }
    public boolean checkIfTheBookIsRemoved(int booksId){
        String idString = "" + booksId;
        try {
            String twoFirstChars = "" + idString.charAt(0) + idString.charAt(1);
            return twoFirstChars.equals("88");
        } catch (Exception e) {
            return false;
        }

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
                if(checkIfTheBookIsRemoved(reading.getBooksId())){
                    int removedId = Integer.parseInt(Integer.toString(reading.getBooksId()).substring(2));
                    Book removedBook = removedBooksFromLibrary.get(removedId);
                    System.out.println("\t(removed book: 88" + removedId  + ") "+ removedBook.getTitle() + ", " + removedBook.getAuthor() + " (" + removedBook.getGenre() + ")" +
                            "\n\t\t\tstart: " + reading.getStartDate());
                } else if(reading.getBooksId()<library.size()){
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
            if(checkIfTheBookIsRemoved(read.getBooksId())){
                int removedId = Integer.parseInt(Integer.toString(read.getBooksId()).substring(2));
                Book removedBook = removedBooksFromLibrary.get(removedId);
                System.out.println("\t(removed book: 88" + removedId  + ") " + removedBook.getTitle() + ", " + removedBook.getAuthor() + " (" + removedBook.getGenre() + ")" +
                        "\n\t\t\tstart: " + read.getStartDate());
            } else if(read.getBooksId()<library.size()){
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

    public void showTheBookReview(int number) throws IOException {
        String titleAndAuthor = opinionsList.get(number);
        Book bookForOpinion = findBookByTitleAndAuthor(titleAndAuthor);

        File readOpinionFile = new File("C:\\Users\\zhuko\\IdeaProjects\\projekt\\reviews\\" +
                bookForOpinion.getTitle() + "__" + bookForOpinion.getAuthor() + ".txt");
        if(!readOpinionFile.exists()){
            System.out.println("Sorry, there is no opinion about this book");
        }
        else if(!readOpinionFile.canRead()){
            System.out.println("Sorry, but you have not access to read it..");
        }
        else{
            BufferedReader tempBR = new BufferedReader(new FileReader(readOpinionFile));
            String line;
            while((line = tempBR.readLine()) != null){
                System.out.println(line);
            }
            tempBR.close();
        }

    }

    public void saveTheBookReview(int id) throws IOException {
        Book bookForOpinion = library.get(id);

        File writeOpinionFile = new File("C:\\Users\\zhuko\\IdeaProjects\\projekt\\reviews\\" +
                bookForOpinion.getTitle() + "__" + bookForOpinion.getAuthor() + ".txt");
        BufferedWriter tempWriter = new BufferedWriter(new FileWriter(writeOpinionFile));
        String opinion;
        do{
            Scanner scanner = new Scanner(System.in);
            opinion = scanner.nextLine();
        } while (opinion.length()==0);
        tempWriter.write(opinion);
        tempWriter.close();
        addOpinionsList(bookForOpinion.getTitle() + ", " + bookForOpinion.getAuthor());
    }

    public void deleteTheBookReview(int number){
        String titleAndAuthor = opinionsList.get(number);
        Book bookForDeletingOpinion = findBookByTitleAndAuthor(titleAndAuthor);

        File deleteOpinionFile = new File("C:\\Users\\zhuko\\IdeaProjects\\projekt\\reviews\\" +
                bookForDeletingOpinion.getTitle() + "__" + bookForDeletingOpinion.getAuthor() + ".txt");
        if(deleteOpinionFile.delete()) {
            System.out.println(deleteOpinionFile.getName() + " -  deleted");
        } else System.out.println("failed");
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

    public void getAllInfoAboutTheParticularBook(int id) throws IOException {
        Book book = library.get(id);
        System.out.println("\t\t\tid: "+id +
                "\n\t\t\ttitle: "+  book.getTitle() +
                "\n\t\t\tauthor: "+ book.getAuthor() +
                "\n\t\t\tgenre: "+ book.getGenre());

        System.out.print("\t\t\treading now: ");
        boolean isItReading = false;
        for(Reading reading:readingList)
            if (reading.getBooksId() == id) {
                isItReading = true;
                System.out.print("\n\t\t\t\tstart: " + reading.getStartDate());
                break;
            }
        System.out.print(isItReading? "": "no");

        System.out.print("\n\t\t\tread periods: ");
        boolean isItRead = false;
        int iterationForReadPeriods = 0;
        for(Read read:readList){
            if(read.getBooksId()==id){
                if(!isItRead) isItRead = true;
                iterationForReadPeriods++;
                System.out.print("\n\t\t\t\t(" + iterationForReadPeriods + ") start: " + read.getStartDate() + ", end: " + read.getEndDate());
            }
        }
        System.out.print(isItRead? "": "no periods");

        System.out.print("\n\t\t\treview: ");
        boolean hasReview = false;
        String fileName = book.getTitle() + ", " + book.getAuthor();
        for(int i=0;i<opinionsList.size();i++){
            if(opinionsList.get(i).equals(fileName)){
                hasReview = true;
                showTheBookReview(i);
            }
        }
        System.out.print(hasReview? "": "no review");

    }
}
