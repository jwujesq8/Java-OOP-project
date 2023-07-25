import java.io.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.channels.NotYetBoundException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
public class main {

    public static void main (String[] args) throws Exception{
//        MyFileWriter libraryWriter = new MyFileWriter();
//        libraryWriter.setContent();

        MyFileReader myLibraryReader = new MyFileReader("C:\\Users\\zhuko\\IdeaProjects\\projekt\\myLibrary.bin");
        Library library = myLibraryReader.getContent();

        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        System.out.println("_________Your library App_________");

        while(true){
            System.out.println(Color.WHITE_BOLD + "\n******************************************************************************");
            System.out.println("""
                    0. change the mode of the app for this session
                    1. see what's in the library
                    2. add a new book to your library
                    3. remove book from library
                    4. see the list of books you are currently reading
                    5. see the list of books I have read
                    6. add book to reading list
                    7. add book to read list
                    8. see the review of the given book
                    9. write a review about the given book
                    10. delete the review about the given book
                    11. see the list \"books to buy\"
                    12. add a book to the list \"books to buy\"
                    13. remove the book from the list \"books to buy\"
                    14. display by certain categories
                    15. see available statistics
                    16. a little toy with thread
                    17. exit the program""");
            System.out.println("******************************************************************************");
            System.out.print(Color.GREEN_BOLD + "your command (number): " + Color.RESET);
            int command = scanner.nextInt();

            //change the mode of the app
            if(command==0){
                System.out.println("Available modes:" +
                        "\n\t1. DEFAULT: load your own existing data (myLibrary.bin)" +
                        "\n\t2. load trial library (trialLibrary.bin)" +
                        "\n\t3. remove my own library");
                System.out.print("Enter your choice: ");
                int modeChoice = scanner.nextInt();

                //DEFAULT: load your own existing data (myLibrary.bin)
                if(modeChoice==1){
                    library = myLibraryReader.getContent();


                    System.out.println("Your own existing library is loaded now");
                }

                //load trial library (trialLibrary.bin)
                else if (modeChoice==2) {
                    MyFileWriter trialLibraryWriter = new MyFileWriter();

                    System.out.print("Do you want to save changes that you made before? (yes/no): ");
                    String save;
                    do{
                        save = scanner.nextLine();
                    } while (!(save.equals("yes") || save.equals("no")));
                    boolean saveChanges = (save.equals("yes"));
                    if(saveChanges) {
                        boolean isItSaved = false;
                        do {
                            isItSaved = trialLibraryWriter.saveMyLibrary(library);
                        } while (!isItSaved);
                    }

                    String trialLibraryFilePath = trialLibraryWriter.setTrialLibrary();

                    MyFileReader trialLibraryReader = new MyFileReader(trialLibraryFilePath);
                    library = trialLibraryReader.getContent();
                    System.out.println("Trial library is loaded now");
                }

                //remove my own library
                else if(modeChoice==3){
                    System.out.print("Are you sure that you want te delete your library? (yes/no): ");
                    String delete;
                    do{
                        delete = scanner.nextLine();
                    } while (!(delete.equals("yes") || delete.equals("no")));
                    boolean deleteLibrary = delete.equals("yes");
                    if(deleteLibrary){
                        MyFileWriter myLibraryWriter = new MyFileWriter();
                        boolean isItDeleted = myLibraryWriter.removeMyLibrary();
                        if(isItDeleted) {
                            System.out.println("Your library is empty now");
                            try{
                                library = myLibraryReader.getContent();
                            } catch (Exception e){
                                System.out.println(e.getMessage());
                            }
                        }
                        else System.out.println("Error with deleting the library. Try again");
                    }
                }

            }

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
                        library.removeBook(booksId);
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                        System.out.println("Most likely there is no book with the given id("+booksId+")");
                    }
            }

            //see the list of books you are currently reading
            if(command==4){
                System.out.println("List of books you are reading now: ");
                library.printReadingList();
            }

            //see the list of books I have read
            if(command==5){
                System.out.println("List of read books: ");
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

                try{
                    library.addReadList(library.getReadingList().get(inputId), dateEnd, like);
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }

            //see the review of the given book
            if(command==8){
                library.printOpinionsList();
                System.out.print("Enter the number of the book which review you want to read: ");
                int number =scanner.nextInt();
                try{
                    library.showTheBookReview(number);
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }

            //write an opinion about the given book
            if(command==9){
                library.printLibrary();
                System.out.print("Enter the id of the book, which review you want to (re)write: ");
                int inputId = scanner.nextInt();
                library.saveTheBookReview(inputId);
            }

            //delete the opinion about the given book
            if(command==10){
                library.printOpinionsList();
                System.out.print("Enter the id of the book, which review you want to delete: ");
                int number = scanner.nextInt();
                try{
                    library.deleteTheBookReview(number);
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }

            //see the list "books to buy"
            if(command==11){
                System.out.println("the list \"books to buy\"");
                int listSizeToBuy=library.getBuyList().size();

                if(listSizeToBuy==0){
                    System.out.println("This list is empty");
                } else library.printBuyList();
            }

            //add a book to the list "books to buy"
            if(command==12){

                String title;
                System.out.print("Enter the title of the book you want to buy: ");
                do{title = scanner.nextLine();}
                    while(title.length()==0);

                System.out.print("Enter the author of the \"" + title + "\": ");
                String author = scanner.nextLine();

                System.out.print("What's a genre of the \"" + title + "\"?: ");
                String genre = scanner.nextLine();

                System.out.print("What books cover would you prefer: (hard/soft) ");
                String cover = scanner.nextLine();

                try{
                    library.addBuyList(new Buy(new Book(title, author, genre), cover));
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }

            //13. remove the book from the list "books to buy"
            if(command==13){
                library.printBuyList();
                System.out.print("Enter the id of the book you want to remove: ");
                int inputId = scanner.nextInt();
                if(inputId<library.getBuyList().size()) library.getBuyList().remove(inputId);
                else System.out.println("There is no book with this id (" + inputId + ") in the buyList..");
            }

            //display by certain categories
            if(command==14){
                System.out.println("Available displays by category: " +
                        "\n\t1. favorite books"
                        + "\n\t2. display all info about the particular book"
                       );
                System.out.print("\tChoose the category: ");
                int categoryChoice= scanner.nextInt();

                if (categoryChoice==1){
                    for(Read readBook: library.getReadList()){
                        if(readBook.isItFavorite){
                            Book book = library.getLibrary().get(readBook.booksId);
                            System.out.println("\t " + book.getTitle() + ", " + book.getAuthor());
                        }
                    }
                }

                if (categoryChoice==2){
                    library.printLibrary();
                    System.out.print("Enter the books id which one would you choose: ");
                    int inputId = scanner.nextInt();
                    try{
                        library.getAllInfoAboutTheParticularBook(inputId);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            }

            //see available statistics
            if(command==15){
                System.out.println("""
                        Available statistics:\s
                        \t1. How many books by the given author
                        \t2. How many times have you read this particular book""");
                System.out.print("\tChoose statistics: ");
                int statisticsChoice = scanner.nextInt();

                //How many books by the given author
                if(statisticsChoice==1){
                    System.out.println("Available authors:");
                    library.printAuthorsList();
                    System.out.print("Enter the author: ");
                    String inputAuthor;
                    do{
                        inputAuthor = scanner.nextLine();
                    }while (inputAuthor.isEmpty());
                    try{
                        library.statisticsHowManyBooksByTheGivenAuthor(inputAuthor);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }

                //How many times have you read this particular book
                if(statisticsChoice==2){
                    library.printLibrary();
                    System.out.print("Enter the books id: ");
                    int inputId = scanner.nextInt();
                    try{
                        library.howManyTimesHaveYouReadThisParticularBook(inputId);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                        System.out.println("Most likely there is no book with the given id (" + inputId + ")");
                    }
                }
            }

            //toy with cotton wool
            if(command==16){
                System.out.println("Well, definitely on the toy.." +
                        "(there is a message which book you want to read now in meantime)");
                MyThread thread = new MyThread(library);
                thread.start();
            }

            //exit the program
            if(command==17){
                MyFileWriter myLibraryWriter = new MyFileWriter();
                myLibraryWriter.saveMyLibrary(library);
                try{
                    System.exit(0);
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
    }
    }
}