import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;

public class FileWriter{
    public static void main(String args[]) throws Exception {
        Biblioteczka biblioteczka = new Biblioteczka();

        int il=0;
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

        Ksiazki ksiazka1 = new Ksiazki();
        ksiazka1.setTytul("Biesy");
        ksiazka1.setAutor("Fiodor Dostojewski");
        ksiazka1.setGatunek("Powieść");
        Czytane czytane1 = new Czytane(ksiazka1, formatter.parse("02.04.2021"));
        ksiazka1.getCzy_czytane().add(czytane1);
            Przeczytane przeczytane1 = new Przeczytane(ksiazka1,formatter.parse("27.06.2021"),true);
            ksiazka1.getCzy_przeczytane().add(przeczytane1);
        biblioteczka.getBiblioteczka().put(il++, ksiazka1);

        Ksiazki ksiazka2 = new Ksiazki();
        ksiazka2.setTytul("Idiota");
        ksiazka2.setAutor("Fiodor Dostojewski");
        ksiazka2.setGatunek("Powieść");
        biblioteczka.getBiblioteczka().put(il++,ksiazka2);

        Ksiazki ksiazka3 = new Ksiazki();
        ksiazka3.setTytul("Gracz");
        ksiazka3.setAutor("Fiodor Dostojewski");
        ksiazka3.setGatunek("Powieść");
        Czytane czytane3 = new Czytane(ksiazka3, formatter.parse("15.04.2022"));
        ksiazka3.getCzy_czytane().add(czytane3);
            Przeczytane przeczytane3 = new Przeczytane(ksiazka3,formatter.parse("22.05.2022"),true);
            ksiazka3.getCzy_przeczytane().add(przeczytane3);
        biblioteczka.getBiblioteczka().put(il++,ksiazka3);

        Ksiazki ksiazka4 = new Ksiazki();
        ksiazka4.setTytul("Bracia Karamazow");
        ksiazka4.setAutor("Fiodor Dostojewski");
        ksiazka4.setGatunek("Powieść");
        Czytane czytane4 = new Czytane(ksiazka4, formatter.parse("30.07.2021"));
        ksiazka4.getCzy_czytane().add(czytane4);
            Przeczytane przeczytane4 = new Przeczytane(ksiazka4, formatter.parse("19.09.2021"),false);
            ksiazka4.getCzy_przeczytane().add(przeczytane4);
        biblioteczka.getBiblioteczka().put(il++,ksiazka4);

        Ksiazki ksiazka5 = new Ksiazki();
        ksiazka5.setTytul("Zbrodnia i kara");
        ksiazka5.setAutor("Fiodor Dostojewski");
        ksiazka5.setGatunek("Powieść");
        Czytane czytane5_1 = new Czytane(ksiazka5, formatter.parse("10.01.2020"));
        ksiazka5.getCzy_czytane().add(czytane5_1);
            Przeczytane przeczytane5_1 = new Przeczytane(ksiazka5, formatter.parse("17.03.2020"),true);
            ksiazka5.getCzy_przeczytane().add(przeczytane5_1);
        Czytane czytane5_2 = new Czytane(ksiazka5, formatter.parse("20.02.2021"));
        ksiazka5.getCzy_czytane().add(czytane5_2);
            Przeczytane przeczytane5_2 = new Przeczytane(ksiazka5, formatter.parse("07.04.2021"));
            ksiazka5.getCzy_przeczytane().add(przeczytane5_2);
        biblioteczka.getBiblioteczka().put(il++,ksiazka5);

        Ksiazki ksiazka6 = new Ksiazki();
        ksiazka6.setTytul("Sen śmiesznego człowieka");
        ksiazka6.setAutor("Fiodor Dostojewski");
        ksiazka6.setGatunek("Opowiadanie");
        Czytane czytane6_1 = new Czytane(ksiazka6, formatter.parse("03.08.2019"));
        ksiazka6.getCzy_czytane().add(czytane6_1);
            Przeczytane przeczytane6_1 = new Przeczytane(ksiazka6, formatter.parse("04.08.2019"),true);
            ksiazka6.getCzy_przeczytane().add(przeczytane6_1);
        Czytane czytane6_2 = new Czytane(ksiazka6, formatter.parse("18.04.2020"));
        ksiazka6.getCzy_czytane().add(czytane6_2);
            Przeczytane przeczytane6_2 = new Przeczytane(ksiazka6, formatter.parse("20.04.2020"));
            ksiazka6.getCzy_przeczytane().add(przeczytane6_2);
        Czytane czytane6_3 = new Czytane(ksiazka6, formatter.parse("17.07.2021"));
        ksiazka6.getCzy_czytane().add(czytane6_3);
            Przeczytane przeczytane6_3 = new Przeczytane(ksiazka6, formatter.parse("17.07.2021"));
            ksiazka6.getCzy_przeczytane().add(przeczytane6_3);
        biblioteczka.getBiblioteczka().put(il++,ksiazka6);

        Ksiazki ksiazka7 = new Ksiazki();
        ksiazka7.setTytul("Biale noce");
        ksiazka7.setAutor("Fiodor Dostojewski");
        ksiazka7.setGatunek("Opowiadanie");
        Czytane czytane7_1 = new Czytane(ksiazka7, formatter.parse("12.05.2020"));
        ksiazka7.getCzy_czytane().add(czytane7_1);
            Przeczytane przeczytane7_1 = new Przeczytane(ksiazka7, formatter.parse("15.05.2020"),true);
            ksiazka7.getCzy_przeczytane().add(przeczytane7_1);
        Czytane czytane7_2 = new Czytane(ksiazka7, formatter.parse("08.04.2022"));
        ksiazka7.getCzy_czytane().add(czytane7_2);
            Przeczytane przeczytane7_2 = new Przeczytane(ksiazka7, formatter.parse("10.04.2022"));
            ksiazka7.getCzy_przeczytane().add(przeczytane7_2);
        biblioteczka.getBiblioteczka().put(il++,ksiazka7);

        Ksiazki ksiazka8 = new Ksiazki();
        ksiazka8.setTytul("O sztuce milosci");
        ksiazka8.setAutor("Erich Fromm");
        ksiazka8.setGatunek("Psychoanaliza");
        Czytane czytane8 = new Czytane(ksiazka8, formatter.parse("02.03.2021"));
        ksiazka8.getCzy_czytane().add(czytane8);
            Przeczytane przeczytane8 = new Przeczytane(ksiazka8, formatter.parse("19.03.2021"), true);
            ksiazka8.getCzy_przeczytane().add(przeczytane8);
        biblioteczka.getBiblioteczka().put(il++,ksiazka8);

        Ksiazki ksiazka9 = new Ksiazki();
        ksiazka9.setTytul("Zbior wierszow");
        ksiazka9.setAutor("Arsienij Tarkowski");
        ksiazka9.setGatunek("Liryka");
        Czytane czytane9 = new Czytane(ksiazka9, formatter.parse("27.09.2021"));
        ksiazka9.getCzy_czytane().add(czytane9);
            Przeczytane przeczytane9 = new Przeczytane(ksiazka9, formatter.parse("11.11.2021"), false);
            ksiazka9.getCzy_przeczytane().add(przeczytane9);
        biblioteczka.getBiblioteczka().put(il++,ksiazka9);

        Ksiazki ksiazka10 = new Ksiazki();
        ksiazka10.setTytul("Rok 1984");
        ksiazka10.setAutor("George Orwell");
        ksiazka10.setGatunek("Fikcja polityczna");
        Czytane czytane10 = new Czytane(ksiazka10, formatter.parse("12.01.2022"));
        ksiazka10.getCzy_czytane().add(czytane10);
            Przeczytane przeczytane10 = new Przeczytane(ksiazka10, formatter.parse("27.02.2022"), false);
            ksiazka10.getCzy_przeczytane().add(przeczytane10);
        biblioteczka.getBiblioteczka().put(il++,ksiazka10);

        Ksiazki ksiazka11 = new Ksiazki();
        ksiazka11.setTytul("Folwark zwierzecy");
        ksiazka11.setAutor("George Orwell");
        ksiazka11.setGatunek("Fikcja polityczna");
        Czytane czytane11 = new Czytane(ksiazka11, formatter.parse("28.02.2022"));
        ksiazka11.getCzy_czytane().add(czytane11);
            Przeczytane przeczytane11 = new Przeczytane(ksiazka11, formatter.parse("13.03.2022"), false);
            ksiazka11.getCzy_przeczytane().add(przeczytane11);
        biblioteczka.getBiblioteczka().put(il++,ksiazka11);

        Ksiazki ksiazka12 = new Ksiazki();
        ksiazka12.setTytul("Morfina");
        ksiazka12.setAutor("Michail Bulhakow");
        ksiazka12.setGatunek("Opowiadanie");
        Czytane czytane12 = new Czytane(ksiazka12, formatter.parse("16.03.2022"));
        ksiazka12.getCzy_czytane().add(czytane12);
            Przeczytane przeczytane12 = new Przeczytane(ksiazka12, formatter.parse("16.03.2022"), true);
            ksiazka12.getCzy_przeczytane().add(przeczytane12);
        biblioteczka.getBiblioteczka().put(il++,ksiazka12);

        Ksiazki ksiazka13 = new Ksiazki();
        ksiazka13.setTytul("Notatki lekarza");
        ksiazka13.setAutor("Michail Bulhakow");
        ksiazka13.setGatunek("Komediodramat");
        Czytane czytane13 = new Czytane(ksiazka13, formatter.parse("20.03.2022"));
        ksiazka13.getCzy_czytane().add(czytane13);
            Przeczytane przeczytane13 = new Przeczytane(ksiazka13, formatter.parse("25.03.2022"), true);
            ksiazka13.getCzy_przeczytane().add(przeczytane13);
        biblioteczka.getBiblioteczka().put(il++,ksiazka13);

        Ksiazki ksiazka14 = new Ksiazki();
        ksiazka14.setTytul("Zapiski na mankietach");
        ksiazka14.setAutor("Michail Bulhakow");
        ksiazka14.setGatunek("Komediodramat");
        Czytane czytane14 = new Czytane(ksiazka14, formatter.parse("29.03.2022"));
        ksiazka14.getCzy_czytane().add(czytane14);
            Przeczytane przeczytane14 = new Przeczytane(ksiazka14, formatter.parse("05.04.2022"), false);
            ksiazka14.getCzy_przeczytane().add(przeczytane14);
        biblioteczka.getBiblioteczka().put(il++,ksiazka14);

        Ksiazki ksiazka15 = new Ksiazki();
        ksiazka15.setTytul("Nocny lot");
        ksiazka15.setAutor("Iosif Brodski");
        ksiazka15.setGatunek("Nowela");
        Czytane czytane15 = new Czytane(ksiazka15, formatter.parse("24.04.2022"));
        ksiazka15.getCzy_czytane().add(czytane15);
        biblioteczka.getBiblioteczka().put(il++,ksiazka15);


        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\zhuko\\IdeaProjects\\projekt\\biblioteczka.bin");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(biblioteczka);
        objectOutputStream.flush();
        objectOutputStream.close();
        fileOutputStream.close();

}}
