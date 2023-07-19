import java.io.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
public class main {
    public static void main (String[] args) throws Exception{
        MyFileWriter booksFileWriter = new MyFileWriter("C:\\Users\\zhuko\\IdeaProjects\\projekt\\library.bin");
        booksFileWriter.setContent();

        MyFileReader booksFileReader = new MyFileReader("C:\\Users\\zhuko\\IdeaProjects\\projekt\\library.bin");
        Library library = booksFileReader.getContent();


//        int countOfBooks = library.getSize();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner scanner = new Scanner(System.in);
        System.out.println("_________Your library App_________");

        while(true){
        System.out.println("******************************************************************************");
        System.out.println("""
                1. see what's in the library
                2. add a new book to your library
                3. remove book from library
                4. see the list of books you are currently reading
                5. see the list of books I have read
                6. add book to reading list
                7. add book to read list
                8. see the review of the given book
                9. write an opinion about the given book
                10. see the list \"books to buy\"
                11. add a book to the list \"books to buy\"
                12. display by certain categories
                13. see available statistics
                14. toy with cotton wool
                15. exit the program""");
        System.out.println("******************************************************************************");
        System.out.print("your command (number): ");
        int command = scanner.nextInt();

        //see what's in the library
        if(command==1){
            System.out.println("The whole library: ");
            library.printLibrary();
        }

        //add a new book to your library
        if(command==2){
            String title;
            do{
                System.out.print("Enter the title of the book: ");
                title = scanner.nextLine();
                } while(title.length()==0);

            System.out.print("Enter the author of the \"" + title + "\": ");
            String author = scanner.nextLine();
            boolean match=library.findMatchBookInTheLibrary(title, author);

            if(!match){
            System.out.print("Enter the genre of the \"" + title + "\": ");
            String genre = scanner.nextLine();

            if(genre.isEmpty()) library.addBook(new Book(title, author, genre));
                else library.addBook(new Book(title, author, genre));


            System.out.println("Now there are "+ library.getSize() + " books in the library now");
            library.printLibrary();
            } else System.out.println("The book \"" + title + "\" by " + author + " already exists in your library");
        }

        //remove book from library
        if(command==3){
            library.printLibrary();
            System.out.print("Enter the id of the book you want to delete: ");
            int booksId = scanner.nextInt();
                try {
                    library.getLibrary().remove(booksId);
                }
                catch(Exception e){
                    System.out.println("Error: " + e.getMessage());
                }
        }

        //see the list of books you are currently reading
        if(command==4){
            System.out.println("List of books you are reading now: ");
            library.printReadingList();
        }

        //see the list of books I have read
        if(command==5){
            System.out.println("List of books read: ");
            library.printReadList();
        }

        //add book to reading list
        if(command==6){
            library.printLibrary();
            System.out.print("Enter the id of the book you want to add to the reading list: ");

            int inputId = scanner.nextInt();
            System.out.print("Enter the start date (pattern: dd. mm. yyyy):");
            Date dateStart = formatter.parse(br.readLine());
            Reading new_reading = new Reading(inputId, dateStart);
            library.addReadingList(new_reading);
        }

        //add book to the read list
        if(command==7) {
            System.out.println("List of books you're reading now: ");
            library.printReadingList();

            System.out.print("Enter the book id from the books list:");
            int inputId = scanner.nextInt();

            System.out.print("Enter end date (pattern: dd.mm.yyyy): ");
            Date dateEnd = formatter.parse(br.readLine());

            System.out.print("Do you like this book? (like yes/no): ");
            String isItFavorite;
            boolean like = false;
            do{
                isItFavorite = scanner.nextLine();
                if(isItFavorite.equals("yes")) like = true;
            } while(isItFavorite.length()==0);

            library.addReadList(library.getReadingList().get(inputId), dateEnd, like);
        }

        //see the review of the given book
        if(command==8){
            library.printLibrary();
            System.out.print("Enter the book id: ");
            int inputId=scanner.nextInt();

            File readOpinionFile = new File("C:\\Users\\zhuko\\IdeaProjects\\projekt\\reviews\\" + library.getLibrary().get(inputId).getTitle() + ".txt");
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

        //write an opinion about the given book
        if(command==9){
            library.printLibrary();
            System.out.print("Enter the id of the book, which review you want to write: ");
            int inputId = scanner.nextInt();

            File writeOpinionFile = new File("C:\\Users\\zhuko\\IdeaProjects\\projekt\\" + library.getLibrary().get(inputId).getTitle() + ".txt");
            BufferedWriter tempWriter = new BufferedWriter(new FileWriter(writeOpinionFile));
            String opinion;
            do{
                opinion = scanner.nextLine();
            } while (opinion.length()==0);
            tempWriter.write(opinion);
            tempWriter.close();
        }

        //see the list "books to buy"
        if(command==10){
            System.out.println("the list \"books to buy\"");
            int listSizeToBuy=library.getBuyList().size();

            if(listSizeToBuy==0){
                System.out.println("This list is empty");
            } else library.printBuyList();
        }

        //add a book to the list "books to buy"
        if(command==11){

            String title;
            System.out.print("Enter the title of the book you want to buy: ");
            do{title = scanner.nextLine();}
                while(title.length()==0);

            System.out.print("Enter the author of the  \"" + title + "\": ");
            String author = scanner.nextLine();

            System.out.print("What's a genre of the \"" + title + "\"?: ");
            String genre = scanner.nextLine();

            System.out.print("What books cover would you prefer: (hard/soft) ");
            String cover = scanner.nextLine();

            library.addBuyList(new Buy(new Book(title, author, genre), cover));
        }

        //display by certain categories
        if(command==12){
            System.out.println("Available displays by category: " +
                    "\n\t1. favorite books"
//                    + "\n\t2. wyswietlic wszystkie informacje o ksiazkach w biblioteczce"
                   );
            int categoryChoice= scanner.nextInt();

            if (categoryChoice==1){
                for(Read readBook: library.getReadList()){
                    if(readBook.isItFavorite){
                        Book book = library.getLibrary().get(readBook.booksId);
                        System.out.println("\t " + book.getTitle() + ", " + book.getAuthor());
                    }
                }
            }
        }

        //see available statistics
        if(command==13){
            System.out.println("""
                    Available statistics:\s
                    \t1. How many books by the given author
                    \t2. How many times have you read this particular book?""");
            int statisticsChoice = scanner.nextInt();

            if(statisticsChoice==1){
                for(Map.Entry<Integer, Ksiazki> entry:library.getLibrary().entrySet()) {
                    Ksiazki book = entry.getValue();
                    System.out.println(book.getAutor());
                    for(Map.Entry<Integer, Ksiazki> entry0:library.getLibrary().entrySet()){
                        Ksiazki book0 = entry0.getValue();
                        if(!book.getAutor().equals(book0.getAutor())){
                            System.out.println(book0.getAutor());
                            book=entry0.getValue();
                        }
                    }
                    break;
                    }
                    System.out.print("Enter the name of one of the authors: ");
                    String authorForStatistics;
                    do {
                        authorForStatistics = scanner.nextLine();
                    }
                    while (authorForStatistics.length() == 0);
                    int booksCountByAuthor = 0;
                    for (Map.Entry<Integer, Ksiazki> entry : library.getLibrary().entrySet()) {
                        Ksiazki book = entry.getValue();
                        if (book.getAutor().equals(authorForStatistics)) {
                            System.out.println(booksCountByAuthor++ + ". " + book.getTytul());
                        }
                    }
                    System.out.println("There are " + booksCountByAuthor + " book by " + authorForStatistics + " in the library");
            }
            if(statisticsChoice==2){
                for(Map.Entry<Integer, Ksiazki> entry:library.getLibrary().entrySet()){
                    Ksiazki book = entry.getValue();
                    System.out.println("\t" + entry.getKey() + ". " + book.getTytul() + " " + book.getAutor());
                }
                System.out.print("Enter the book id: ");
                int id = scanner.nextInt();
                int times=0;
                Ksiazki book = library.getLibrary().get(id);
                System.out.println(book.getTytul() + " byla przeczytana: ");
                for(Przeczytane read: book.getCzy_przeczytane()){
                    System.out.println("\t" + times++ + ". " + read.getEndDate());
                }
                System.out.println("You've read it " + times + " times");
            }
        }

        //toy with cotton wool
        if(command==14){
            System.out.println("Well, definitely on the toy.." +
                    "(there is a message which book you want to read now in meantime)");
            int size=library.getLibrary().size();

            for (int j = 1; j < 3; j++) {
                    int randomBook = (int) (Math.random() * size);
                    Watek thread1 = new Watek(library.getLibrary().get(randomBook));
                    thread1.start();
                    randomBook=(int) (Math.random() * size);
                    Watek thread2 = new Watek(library.getLibrary().get(randomBook % 3));
                    thread2.start();

                }

        }

        //exit the program
        if(command==15){
            System.exit(0);
        }
    }
    }
}