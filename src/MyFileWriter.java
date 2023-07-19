import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class MyFileWriter{
    public String file;
    public MyFileWriter(String fileName) {
        this.file = fileName;
    }

    public void setContent() throws Exception {
        List<Ksiazki> library = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

        Ksiazki book1 = new Ksiazki();
        book1.setTytul("Biesy");
        book1.setAutor("Fiodor Dostojewski");
        book1.setGatunek("Powieść");
        Czytane czytane1 = new Czytane(book1, formatter.parse("02.04.2021"));
        book1.getCzy_czytane().add(czytane1);
            Przeczytane przeczytane1 = new Przeczytane(book1,formatter.parse("27.06.2021"),true);
            book1.getCzy_przeczytane().add(przeczytane1);
        library.add(book1);

        Ksiazki book2 = new Ksiazki();
        book2.setTytul("Idiota");
        book2.setAutor("Fiodor Dostojewski");
        book2.setGatunek("Powieść");
        library.add(book2);

        Ksiazki book3 = new Ksiazki();
        book3.setTytul("Gracz");
        book3.setAutor("Fiodor Dostojewski");
        book3.setGatunek("Powieść");
        Czytane czytane3 = new Czytane(book3, formatter.parse("15.04.2022"));
        book3.getCzy_czytane().add(czytane3);
            Przeczytane przeczytane3 = new Przeczytane(book3,formatter.parse("22.05.2022"),true);
            book3.getCzy_przeczytane().add(przeczytane3);
        library.add(book3);

        Ksiazki book4 = new Ksiazki();
        book4.setTytul("Bracia Karamazow");
        book4.setAutor("Fiodor Dostojewski");
        book4.setGatunek("Powieść");
        Czytane czytane4 = new Czytane(book4, formatter.parse("30.07.2021"));
        book4.getCzy_czytane().add(czytane4);
            Przeczytane przeczytane4 = new Przeczytane(book4, formatter.parse("19.09.2021"),false);
            book4.getCzy_przeczytane().add(przeczytane4);
        library.add(book4);

        Ksiazki book5 = new Ksiazki();
        book5.setTytul("Zbrodnia i kara");
        book5.setAutor("Fiodor Dostojewski");
        book5.setGatunek("Powieść");
        Czytane czytane5_1 = new Czytane(book5, formatter.parse("10.01.2020"));
        book5.getCzy_czytane().add(czytane5_1);
            Przeczytane przeczytane5_1 = new Przeczytane(book5, formatter.parse("17.03.2020"),true);
            book5.getCzy_przeczytane().add(przeczytane5_1);
        Czytane czytane5_2 = new Czytane(book5, formatter.parse("20.02.2021"));
        book5.getCzy_czytane().add(czytane5_2);
            Przeczytane przeczytane5_2 = new Przeczytane(book5, formatter.parse("07.04.2021"));
            book5.getCzy_przeczytane().add(przeczytane5_2);
        library.add(book5);

        Ksiazki book6 = new Ksiazki();
        book6.setTytul("Sen śmiesznego człowieka");
        book6.setAutor("Fiodor Dostojewski");
        book6.setGatunek("Opowiadanie");
        Czytane czytane6_1 = new Czytane(book6, formatter.parse("03.08.2019"));
        book6.getCzy_czytane().add(czytane6_1);
            Przeczytane przeczytane6_1 = new Przeczytane(book6, formatter.parse("04.08.2019"),true);
            book6.getCzy_przeczytane().add(przeczytane6_1);
        Czytane czytane6_2 = new Czytane(book6, formatter.parse("18.04.2020"));
        book6.getCzy_czytane().add(czytane6_2);
            Przeczytane przeczytane6_2 = new Przeczytane(book6, formatter.parse("20.04.2020"));
            book6.getCzy_przeczytane().add(przeczytane6_2);
        Czytane czytane6_3 = new Czytane(book6, formatter.parse("17.07.2021"));
        book6.getCzy_czytane().add(czytane6_3);
            Przeczytane przeczytane6_3 = new Przeczytane(book6, formatter.parse("17.07.2021"));
            book6.getCzy_przeczytane().add(przeczytane6_3);
        library.add(book6);

        Ksiazki book7 = new Ksiazki();
        book7.setTytul("Biale noce");
        book7.setAutor("Fiodor Dostojewski");
        book7.setGatunek("Opowiadanie");
        Czytane czytane7_1 = new Czytane(book7, formatter.parse("12.05.2020"));
        book7.getCzy_czytane().add(czytane7_1);
            Przeczytane przeczytane7_1 = new Przeczytane(book7, formatter.parse("15.05.2020"),true);
            book7.getCzy_przeczytane().add(przeczytane7_1);
        Czytane czytane7_2 = new Czytane(book7, formatter.parse("08.04.2022"));
        book7.getCzy_czytane().add(czytane7_2);
            Przeczytane przeczytane7_2 = new Przeczytane(book7, formatter.parse("10.04.2022"));
            book7.getCzy_przeczytane().add(przeczytane7_2);
        library.add(book7);

        Ksiazki book8 = new Ksiazki();
        book8.setTytul("O sztuce milosci");
        book8.setAutor("Erich Fromm");
        book8.setGatunek("Psychoanaliza");
        Czytane czytane8 = new Czytane(book8, formatter.parse("02.03.2021"));
        book8.getCzy_czytane().add(czytane8);
            Przeczytane przeczytane8 = new Przeczytane(book8, formatter.parse("19.03.2021"), true);
            book8.getCzy_przeczytane().add(przeczytane8);
        library.add(book8);

        Ksiazki book9 = new Ksiazki();
        book9.setTytul("Zbior wierszow");
        book9.setAutor("Arsienij Tarkowski");
        book9.setGatunek("Liryka");
        Czytane czytane9 = new Czytane(book9, formatter.parse("27.09.2021"));
        book9.getCzy_czytane().add(czytane9);
            Przeczytane przeczytane9 = new Przeczytane(book9, formatter.parse("11.11.2021"), false);
            book9.getCzy_przeczytane().add(przeczytane9);
        library.add(book9);

        Ksiazki book10 = new Ksiazki();
        book10.setTytul("Rok 1984");
        book10.setAutor("George Orwell");
        book10.setGatunek("Fikcja polityczna");
        Czytane czytane10 = new Czytane(book10, formatter.parse("12.01.2022"));
        book10.getCzy_czytane().add(czytane10);
            Przeczytane przeczytane10 = new Przeczytane(book10, formatter.parse("27.02.2022"), false);
            book10.getCzy_przeczytane().add(przeczytane10);
        library.add(book10);

        Ksiazki book11 = new Ksiazki();
        book11.setTytul("Folwark zwierzecy");
        book11.setAutor("George Orwell");
        book11.setGatunek("Fikcja polityczna");
        Czytane czytane11 = new Czytane(book11, formatter.parse("28.02.2022"));
        book11.getCzy_czytane().add(czytane11);
            Przeczytane przeczytane11 = new Przeczytane(book11, formatter.parse("13.03.2022"), false);
            book11.getCzy_przeczytane().add(przeczytane11);
        library.add(book11);

        Ksiazki book12 = new Ksiazki();
        book12.setTytul("Morfina");
        book12.setAutor("Michail Bulhakow");
        book12.setGatunek("Opowiadanie");
        Czytane czytane12 = new Czytane(book12, formatter.parse("16.03.2022"));
        book12.getCzy_czytane().add(czytane12);
            Przeczytane przeczytane12 = new Przeczytane(book12, formatter.parse("16.03.2022"), true);
            book12.getCzy_przeczytane().add(przeczytane12);
        library.add(book12);

        Ksiazki book13 = new Ksiazki();
        book13.setTytul("Notatki lekarza");
        book13.setAutor("Michail Bulhakow");
        book13.setGatunek("Komediodramat");
        Czytane czytane13 = new Czytane(book13, formatter.parse("20.03.2022"));
        book13.getCzy_czytane().add(czytane13);
            Przeczytane przeczytane13 = new Przeczytane(book13, formatter.parse("25.03.2022"), true);
            book13.getCzy_przeczytane().add(przeczytane13);
        library.add(book13);

        Ksiazki book14 = new Ksiazki();
        book14.setTytul("Zapiski na mankietach");
        book14.setAutor("Michail Bulhakow");
        book14.setGatunek("Komediodramat");
        Czytane czytane14 = new Czytane(book14, formatter.parse("29.03.2022"));
        book14.getCzy_czytane().add(czytane14);
            Przeczytane przeczytane14 = new Przeczytane(book14, formatter.parse("05.04.2022"), false);
            book14.getCzy_przeczytane().add(przeczytane14);
        library.add(book14);

        Ksiazki book15 = new Ksiazki();
        book15.setTytul("Nocny lot");
        book15.setAutor("Iosif Brodski");
        book15.setGatunek("Nowela");
        Czytane czytane15 = new Czytane(book15, formatter.parse("24.04.2022"));
        book15.getCzy_czytane().add(czytane15);
        library.add(book15);


        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(library);
        objectOutputStream.flush();
        objectOutputStream.close();
        fileOutputStream.close();

    }}
