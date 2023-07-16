import java.io.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
public class main {
    public static void main (String[] args) throws Exception{
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\zhuko\\IdeaProjects\\projekt\\biblioteczka.bin");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Library library = (Library) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();

        int countOfBooks=15;
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Your library");
        boolean go = true;
        List<Kupic> toBuy = new ArrayList<>();

        while(go){
        System.out.println("******************************************************************************");
        System.out.println("""
                1. see what's in the library
                2. add a new book to your library
                3. remove book from library
                4. see the list of books you are currently reading
                5. see the list of books I would read
                6. add book to reading list
                7. add book to read list
                8. see the review of the given book
                9. write an opinion about the given book
                10. see the list \\"books to buy\\"
                11. add a book to the list \\ " books to buy\\"
                12. display by certain categories
                13. see available statistics
                14. toy with cotton wool
                15. exit the program""");
        System.out.println("******************************************************************************");
        System.out.print("your command (number): ");
        int command = scanner.nextInt();

        if(command==1){
            System.out.println("The whole library: ");
            for(Map.Entry<Integer, Ksiazki> entry:library.getLibrary().entrySet()){
                Ksiazki book = entry.getValue();
                System.out.println("\t" + entry.getKey() + ". " + book.getTytul() + " " + book.getAutor());
            }
        }


        if(command==2){
            String title;
            do{
                System.out.print("Enter the title of the book: ");
                title = scanner.nextLine();
                } while(title.length()==0);

            System.out.print("Enter the author \"" + title + "\": ");
            String author = scanner.nextLine();
            boolean matches=false;
            for(Map.Entry<Integer, Ksiazki> entry:library.getLibrary().entrySet() ){
                Ksiazki book = entry.getValue();
                if(book.getTytul().equals(title) && book.getAutor().equals(author)){
                    System.out.println("Książka \"" + title + "\" o autorze " + author + " już jest w biblioteczce");
                    matches=true;

                }
            }
            if(!matches){
            System.out.print("Enter the genre of the \"" + title + "\": ");
            String genre = scanner.nextLine();

            Ksiazki newBook = new Ksiazki();
            newBook.setTytul(title);
            newBook.setAutor(author);
            newBook.setGatunek(genre);
            library.getLibrary().put(countOfBooks++, newBook);

            System.out.println("Now there are \"+ countOfBooks + \" books in the library");
            for(Map.Entry<Integer, Ksiazki> entry:library.getLibrary().entrySet()){
                Ksiazki book = entry.getValue();
                System.out.println("\t" + entry.getKey() + ". " + book.getTytul() + " " + book.getAutor());
            }
            }
        }

        if(command==3){
            for(Map.Entry<Integer, Ksiazki> entry:library.getLibrary().entrySet()){
                Ksiazki book = entry.getValue();
                System.out.println("\t" + entry.getKey() + ". " + book.getTytul() + " " + book.getAutor());
            }
            System.out.print("Enter the id of the book you want to delete: ");
            int booksId = scanner.nextInt();
                try {
                    library.getLibrary().remove(booksId);
                }
                catch(Exception e){
                    System.out.println("Error: " + e.getMessage());
                }
        }

        if(command==4){
            System.out.println("List of books you are reading now: ");
            for(Map.Entry<Integer, Ksiazki> entry:library.getLibrary().entrySet()){
                Ksiazki book = entry.getValue();
                if(!entry.getValue().getCzy_czytane().isEmpty() && entry.getValue().getCzy_przeczytane().isEmpty()) {
                    System.out.println("\t" + entry.getKey() + ". " + book.getTytul() + " " + book.getAutor());
                    for(Czytane czytane: book.getCzy_czytane()){
                        System.out.println("\t\t" + czytane.getStartDate());
                    }
                }
            }
        }

        if(command==5){
            System.out.println("List of books read: ");
            for(Map.Entry<Integer, Ksiazki> entry:library.getLibrary().entrySet()){
                Ksiazki book = entry.getValue();
                if(!entry.getValue().getCzy_przeczytane().isEmpty()){
                    System.out.println("\t" + entry.getKey() + ". " + book.getTytul() + " " + book.getAutor());
                }
            }
        }

        if(command==6){
            for(Map.Entry<Integer, Ksiazki> entry:library.getLibrary().entrySet()){
                Ksiazki book = entry.getValue();
                System.out.println("\t" + entry.getKey() + ". " + book.getTytul() + " " + book.getAutor());
            }
            System.out.print("Enter the id of the book you want to add to reading list: ");
            int input = scanner.nextInt();
            System.out.print("Enter the start date (pattern: dd. mm. yyyy):");
            Date dateStart = formatter.parse(br.readLine());
            Czytane new_czytane = new Czytane(library.getLibrary().get(input), dateStart);
            library.getLibrary().get(input).getCzy_czytane().add(new_czytane);
        }

        if(command==7) {
            System.out.println("List of books read now: ");
            for (Map.Entry<Integer, Ksiazki> entry : library.getLibrary().entrySet()) {
                Ksiazki book = entry.getValue();
                if (!entry.getValue().getCzy_czytane().isEmpty() && entry.getValue().getCzy_przeczytane().isEmpty()) {
                    System.out.println("\t" + entry.getKey() + ". " + book.getTytul() + " " + book.getAutor());
                }
            }
            System.out.print("Enter the book id from the books list you have read:");
            int input = scanner.nextInt();
            System.out.print("Enter end date (pattern: dd.mm.yyyy): ");
            Date dateEnd = formatter.parse(br.readLine());
            Przeczytane newRead = new Przeczytane(library.getLibrary().get(input),dateEnd);
            System.out.print("Do you like this book? (like yes/no): ");
            String isItFavorite;
            boolean love;
            do{
                isItFavorite = scanner.nextLine();
                if(isItFavorite.equals("yes")) {
                    love = true;
                    newRead.setCzy_ulubiona(love);
                    }
                    else {
                        love = false;
                        newRead.setCzy_ulubiona(love);
                    }
            } while(isItFavorite.length()==0);

            library.getLibrary().get(input).getCzy_przeczytane().add(newRead);

        }

        if(command==8){
            for(Map.Entry<Integer, Ksiazki> entry:library.getLibrary().entrySet()){
                Ksiazki book = entry.getValue();
                System.out.println("\t" + entry.getKey() + ". " + book.getTytul() + " " + book.getAutor());
            }
            System.out.print("Enter book id: ");
            int id=scanner.nextInt();
            File readOpinionFile = new File("C:\\Users\\zhuko\\IdeaProjects\\projekt\\" + library.getLibrary().get(id).getTytul() + ".txt");
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

        if(command==9){
            for(Map.Entry<Integer, Ksiazki> entry:library.getLibrary().entrySet()){
                Ksiazki book = entry.getValue();
                System.out.println("\t" + entry.getKey() + ". " + book.getTytul() + " " + book.getAutor());
            }
            System.out.print("Enter the id of the book, which review you want to write: ");
            int id = scanner.nextInt();
            File writeOpinionFile = new File("C:\\Users\\zhuko\\IdeaProjects\\projekt\\" + library.getLibrary().get(id).getTytul() + ".txt");
            BufferedWriter tempWriter = new BufferedWriter(new FileWriter(writeOpinionFile));
            String opinion;
            do{
                opinion = scanner.nextLine();
            } while (opinion.length()==0);
            tempWriter.write(opinion);
            tempWriter.close();
        }

        if(command==10){
            System.out.println("add a book to the list \" books to buy\"");
            int listSizeToBuy=toBuy.size();

            if(listSizeToBuy==0){
                System.out.println("This list is empty");
            }
            for(int i=0;i < toBuy.size();i++){
                System.out.println("\t" + "\"" + toBuy.get(i).getTytul()
                        + "\" " + toBuy.get(i).getAutor()
                        + ", " + toBuy.get(i).getGatunek()
                        + ", " + toBuy.get(i).getOslona() + " oslona");
            }
        }

        if(command==11){
            Kupic newToBuy = new Kupic();

            String title;
            System.out.print("Enter the title of the book you want to buy: ");
            do{title = scanner.nextLine();}
                while(title.length()==0);
            newToBuy.setTytul(title);

            System.out.print("Enter the author of the  \"" + title + "\": ");
            String author = scanner.nextLine();
            newToBuy.setAutor(author);

            System.out.print("What's a genre of the \"" + title + "\"?: ");
            String genre = scanner.nextLine();
            newToBuy.setGatunek(genre);

            System.out.print("What book cover would you prefer: (hard/soft) ");
            String cover = scanner.nextLine();
            newToBuy.setOslona(cover);

            toBuy.add(newToBuy);
        }

        if(command==12){
            System.out.println("Available displays by category: " +
                    "\n\t1. favorite books"
//                    + "\n\t2. wyswietlic wszystkie informacje o ksiazkach w biblioteczce"
                   );
            int categoryChoice= scanner.nextInt();

            if (categoryChoice==1){
                for(Map.Entry<Integer, Ksiazki> entry:library.getLibrary().entrySet()){
                    Ksiazki book = entry.getValue();
                    for(Przeczytane readBook: book.getCzy_przeczytane()){
                        if(readBook.czy_ulubiona){

                            System.out.println("\t " + book.getTytul()
                            + " " + book.getAutor());
                        }
                    }
                }
            }
            }

        if(command==13){
            System.out.println("Available statistics: " +
                    "\n\t1. How many books by the given author" +
                    "\n\t2. How many times have you read particuler book?");
            int sw = scanner.nextInt();
            if(sw==1){
                for(Map.Entry<Integer, Ksiazki> entry:library.getLibrary().entrySet()) {
                    Ksiazki ksiazka = entry.getValue();
                    System.out.println(ksiazka.getAutor());
                    for(Map.Entry<Integer, Ksiazki> entry0:library.getLibrary().entrySet()){
                        Ksiazki ksiazka0 = entry0.getValue();
                        if(!ksiazka.getAutor().equals(ksiazka0.getAutor())){
                            System.out.println(ksiazka0.getAutor());
                            ksiazka=entry0.getValue();
                        }
                    }
                    break;
                    }
                    System.out.print("Podaj imie i nazwisko jednego z podanych autorow: ");
                    String pod_aut;
                    do {
                        pod_aut = scanner.nextLine();
                    }
                    while (pod_aut.length() == 0);
                    int p = 0;
                    for (Map.Entry<Integer, Ksiazki> entry : library.getLibrary().entrySet()) {
                        Ksiazki ksiazka = entry.getValue();
                        if (ksiazka.getAutor().equals(pod_aut)) {
                            System.out.println(p++ + ". " + ksiazka.getTytul());
                        }
                    }
                    System.out.println("Czyli jest " + p + " ksiazek w biblioteczce o autorze " + pod_aut);
            }
            if(sw==2){
                for(Map.Entry<Integer, Ksiazki> entry:library.getLibrary().entrySet()){
                    Ksiazki ksiazka = entry.getValue();
                    System.out.println("\t" + entry.getKey() + ". " + ksiazka.getTytul() + " " + ksiazka.getAutor());
                }
                System.out.print("Podaj klucz ksiazki: ");
                int kl = scanner.nextInt();
                int p=0;
                Ksiazki ksiazka = library.getLibrary().get(kl);
                System.out.println(ksiazka.getTytul() + " byla przeczytana: ");
                for(Przeczytane przeczytana: ksiazka.getCzy_przeczytane()){
                    System.out.println("\t" + p++ + ". " + przeczytana.getEndDate());
                }
                System.out.println("Czyli przeczytale(-a)s " + p + "razy te ksiazke");
            }
        }

        //wateczek))
        if(command==14){
            System.out.println("No coz, zdecydowale(-a)s na zabawke..(zabawka polega na tym, ze w miedzyczasie pojawia sie komunikat, jaka ksiazke chce przeczytac teraz. )");
            int size=library.getLibrary().size();

            for (int j = 1; j < 3; j++) {
                    int w = (int) (Math.random() * size);
                    Watek watek1 = new Watek(library.getLibrary().get(w));
                    watek1.start();
                    w=(int) (Math.random() * size);
                    Watek watek2 = new Watek(library.getLibrary().get(w % 3));
                    watek2.start();

                }

        }

        //wyjscie z programu
        if(command==15){
            System.exit(0);
        }







    }
    }

}