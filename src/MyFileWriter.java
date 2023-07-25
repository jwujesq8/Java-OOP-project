import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MyFileWriter{
    public String filePath;
    public MyFileWriter() {
    }

    public void setMyLibrary(){

    }

    public void setContent() throws Exception {


    }
    public String setTrialLibrary() throws Exception{
        this.filePath = "C:\\Users\\zhuko\\IdeaProjects\\projekt\\trialLibrary.bin";
        Library library = new Library();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

        Book book1 = new Book("Biesy", "Fiodor Dostojewski", "Powieść");
        library.addBook(book1);
        Reading reading1 = new Reading(library.getSize()-1, formatter.parse("02.04.2021"));
        library.addReadingList(reading1);
        library.addReadList(reading1, formatter.parse("27.06.2021"),true);

        Book book2 = new Book("Idiota", "Fiodor Dostojewski","Powieść");
        library.addBook(book2);

        Book book3 = new Book("Gracz", "Fiodor Dostojewski","Powieść");
        library.addBook(book3);
        Reading reading3 = new Reading(library.getSize()-1, formatter.parse("15.04.2022"));
        library.addReadingList(reading3);
        library.addReadList(reading3, formatter.parse("22.05.2022"),true);
        library.addOpinionsList(book3.getTitle() + ", " + book3.getAuthor());


        Book book4 = new Book("Bracia Karamazow", "Fiodor Dostojewski", "Powieść");
        library.addBook(book4);
        Reading reading4 = new Reading(library.getSize()-1, formatter.parse("30.07.2021"));
        library.addReadingList(reading4);
        library.addReadList(reading4, formatter.parse("19.09.2021"),false);
        library.addOpinionsList(book4.getTitle() + ", " + book4.getAuthor());


        Book book5 = new Book("Zbrodnia i kara", "Fiodor Dostojewski", "Powieść");
        library.addBook(book5);
        Reading reading5_1 = new Reading(library.getSize()-1, formatter.parse("10.01.2020"));
        library.addReadingList(reading5_1);
        library.addReadList(reading5_1, formatter.parse("17.03.2020"),true);
        Reading reading5_2 = new Reading(library.getSize()-1, formatter.parse("20.02.2021"));
        library.addReadingList(reading5_2);
        library.addReadList(reading5_2, formatter.parse("07.04.2021"));

        Book book6 = new Book("Sen śmiesznego człowieka", "Fiodor Dostojewski", "Opowiadanie");
        library.addBook(book6);
        Reading reading6_1 = new Reading(library.getSize()-1, formatter.parse("03.08.2019"));
        library.addReadingList(reading6_1);
        library.addReadList(reading6_1, formatter.parse("04.08.2019"),true);
        Reading reading6_2 = new Reading(library.getSize()-1, formatter.parse("18.04.2020"));
        library.addReadingList(reading6_2);
        library.addReadList(reading6_2, formatter.parse("20.04.2020"));
        Reading reading6_3 = new Reading(library.getSize()-1, formatter.parse("17.07.2021"));
        library.addReadingList(reading6_3);
        library.addReadList(reading6_3, formatter.parse("17.07.2021"));
        library.addOpinionsList(book6.getTitle() + ", " + book6.getAuthor());

        Book book7 = new Book("Biale noce", "Fiodor Dostojewski", "Opowiadanie");
        library.addBook(book7);
        Reading reading7_1 = new Reading(library.getSize()-1, formatter.parse("12.05.2020"));
        library.addReadingList(reading7_1);
        library.addReadList(reading7_1, formatter.parse("15.05.2020"),true);
        Reading reading7_2 = new Reading(library.getSize()-1, formatter.parse("08.04.2022"));
        library.addReadingList(reading7_2);
        library.addReadList(reading7_2, formatter.parse("10.04.2022"));

        Book book8 = new Book("O sztuce milosci", "Erich Fromm", "Psychoanaliza");
        library.addBook(book8);
        Reading reading8 = new Reading(library.getSize()-1, formatter.parse("02.03.2021"));
        library.addReadingList(reading8);
        library.addReadList(reading8, formatter.parse("19.03.2021"), true);

        Book book9 = new Book("Zbior wierszow", "Arsienij Tarkowski", "Liryka");
        library.addBook(book9);
        Reading reading9 = new Reading(library.getSize()-1, formatter.parse("27.09.2021"));
        library.addReadingList(reading9);
        library.addReadList(reading9, formatter.parse("11.11.2021"), false);

        Book book10 = new Book("Rok 1984", "George Orwell", "Fikcja polityczna");
        library.addBook(book10);
        Reading reading10 = new Reading(library.getSize()-1, formatter.parse("12.01.2022"));
        library.addReadingList(reading10);
        library.addReadList(reading10, formatter.parse("27.02.2022"), false);


        Book book11 = new Book("Folwark zwierzecy", "George Orwell", "Fikcja polityczna");
        library.addBook(book11);
        Reading reading11 = new Reading(library.getSize()-1, formatter.parse("28.02.2022"));
        library.addReadingList(reading11);
        library.addReadList(reading11, formatter.parse("13.03.2022"), false);


        Book book12 = new Book("Morfina", "Michail Bulhakow", "Opowiadanie");
        library.addBook(book12);
        Reading reading12 = new Reading(library.getSize()-1, formatter.parse("16.03.2022"));
        library.addReadingList(reading12);
        library.addReadList(reading12, formatter.parse("16.03.2022"), true);


        Book book13 = new Book("Notatki lekarza", "Michail Bulhakow", "Komediodramat");
        library.addBook(book13);
        Reading reading13 = new Reading(library.getSize()-1, formatter.parse("20.03.2022"));
        library.addReadingList(reading13);
        library.addReadList(reading13, formatter.parse("25.03.2022"), true);


        Book book14 = new Book("Zapiski na mankietach", "Michail Bulhakow", "Komediodramat");
        library.addBook(book14);
        Reading reading14 = new Reading(library.getSize()-1, formatter.parse("29.03.2022"));
        library.addReadingList(reading14);
        library.addReadList(reading14, formatter.parse("05.04.2022"), false);


        Book book15 = new Book("Nocny lot", "Iosif Brodski", "Nowela");
        library.addBook(book15);
        Reading reading15 = new Reading(library.getSize()-1, formatter.parse("24.04.2022"));
        library.addReadingList(reading15);

        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(library);
        objectOutputStream.flush();
        objectOutputStream.close();
        fileOutputStream.close();

        return filePath;
    }

    public boolean saveMyLibrary(Library library) throws IOException {
        this.filePath = "C:\\Users\\zhuko\\IdeaProjects\\projekt\\myLibrary.bin";

        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(library);
        Date timeNow = new Date();
        System.out.println("timeNow: " + timeNow);

        objectOutputStream.flush();
        objectOutputStream.close();
        fileOutputStream.close();

        File file = new File(filePath);
        long lastModified = file.lastModified();
        Date date = new Date(lastModified);
        System.out.println("lastModified: " + date);

        return date.compareTo(timeNow) == 0;
    }

    public boolean removeMyLibrary(){
        this.filePath = "C:\\Users\\zhuko\\IdeaProjects\\projekt\\myLibrary.bin";

        File file = new File(filePath);
        return file.delete();
    }

    }
