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
        Biblioteczka biblioteczka = (Biblioteczka) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();

        int il=15;
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Mała biblioteczka Aleny Zhukouskiej ))");
        boolean running = true;
        List<Kupic> do_kupienia = new ArrayList<>();

        while(running){
        System.out.println("******************************************************************************");
        System.out.println("1. zobaczyc, co jest w biblioteczce                                         *" +
                            "\n2. dodać do biblioteczki nową książkę                                       *" +
                            "\n3. usunąć książkę z biblioteczki                                            *" +
                            "\n4. zobaczyć listę czytanych teraz książki                                   *" +
                            "\n5. zobaczyć listę przeczytabych książek                                     *" +
                            "\n6. dodać książkę do listy czytane                                           *" +
                            "\n7. dodać książkę do listy przeczytane                                       *" +
                            "\n8. zobaczyć opinię o podanej książce                                        *" +
                            "\n9. napisać opinię o podanej książce                                         *" +
                            "\n10. zobaczyć listę \"książki do kupienia\"                                    *" +
                            "\n11. dodać książkę do listy \"książki do kupienia\"                            *" +
                            "\n12. wyświetlanie wg pewnych kategorii                                       *" +
                            "\n13. zobaczyć dostępne statystyki                                            *" +
                            "\n14. zabawka z watkiem                                                       *" +
                            "\n15. wyjscie z programu                                                      *");
        System.out.println("******************************************************************************");
        System.out.print("Wpisz polecenie: ");
        int polecenie = scanner.nextInt();

        //zobaczyc ksiazki w biblioteczce
        if(polecenie==1){
            System.out.println("Cała biblioteczka: ");
            for(Map.Entry<Integer, Ksiazki> entry:biblioteczka.getBiblioteczka().entrySet()){
                Ksiazki ksiazka = entry.getValue();
                System.out.println("\t" + entry.getKey() + ". " + ksiazka.getTytul() + " " + ksiazka.getAutor());
            }
        }


        //dodac nowa ksiazke
        if(polecenie==2){
            String tytul;
            do{
                System.out.print("Wpisz tytuł książki: ");
                tytul = scanner.nextLine();
                } while(tytul.length()==0);

            System.out.print("Wpisz autora \"" + tytul + "\": ");
            String autor = scanner.nextLine();
            boolean matches=false;
            for(Map.Entry<Integer, Ksiazki> entry:biblioteczka.getBiblioteczka().entrySet() ){
                Ksiazki ksiazka = entry.getValue();
                if(ksiazka.getTytul().equals(tytul) && ksiazka.getAutor().equals(autor)){
                    System.out.println("Książka \"" + tytul + "\" o autorze " + autor + " już jest w biblioteczce");
                    matches=true;

                }
            }
            if(!matches){
            System.out.println("Nie ma jeszcze takiej książki w biblioteczce");
            System.out.print("Wpisz gatunek \"" + tytul + "\": ");
            String gatunek = scanner.nextLine();

            Ksiazki new_ksiazka = new Ksiazki();
            new_ksiazka.setTytul(tytul);
            new_ksiazka.setAutor(autor);
            new_ksiazka.setGatunek(gatunek);
            biblioteczka.getBiblioteczka().put(il++, new_ksiazka);

            System.out.println("Teraz w biblioteczce znajduje się " + il + " książek");
            for(Map.Entry<Integer, Ksiazki> entry:biblioteczka.getBiblioteczka().entrySet()){
                Ksiazki ksiazka = entry.getValue();
                System.out.println("\t" + entry.getKey() + ". " + ksiazka.getTytul() + " " + ksiazka.getAutor());
            }
            }
        }

        //usunac ksiazke z biblioteczki
        if(polecenie==3){
            for(Map.Entry<Integer, Ksiazki> entry:biblioteczka.getBiblioteczka().entrySet()){
                Ksiazki ksiazka = entry.getValue();
                System.out.println("\t" + entry.getKey() + ". " + ksiazka.getTytul() + " " + ksiazka.getAutor());
            }
            System.out.print("Podaj klucz książki, którą chcesz usunąć: ");
            int input = scanner.nextInt();
                try {
                    biblioteczka.getBiblioteczka().remove(input);
                }
                catch(Exception e){
                    System.out.println("Błąd: " + e.getMessage());
                }
        }

        //zobaczyc liste czytanych ksiazek w tym momencie
        if(polecenie==4){
            System.out.println("Lista czytanych teraz ksizek: ");
            for(Map.Entry<Integer, Ksiazki> entry:biblioteczka.getBiblioteczka().entrySet()){
                Ksiazki ksiazka = entry.getValue();
                if(!entry.getValue().getCzy_czytane().isEmpty() && entry.getValue().getCzy_przeczytane().isEmpty()) {
                    System.out.println("\t" + entry.getKey() + ". " + ksiazka.getTytul() + " " + ksiazka.getAutor());
                    for(Czytane czytane: ksiazka.getCzy_czytane()){
                        System.out.println("\t\t" + czytane.getStartDate());
                    }
                }
            }
        }

        //zobaczyc liste przeczytanych ksiazek
        if(polecenie==5){
            System.out.println("Lista przeczytanych książek: ");
            for(Map.Entry<Integer, Ksiazki> entry:biblioteczka.getBiblioteczka().entrySet()){
                Ksiazki ksiazka = entry.getValue();
                if(!entry.getValue().getCzy_przeczytane().isEmpty()){
                    System.out.println("\t" + entry.getKey() + ". " + ksiazka.getTytul() + " " + ksiazka.getAutor());
                }
            }
        }

        //dodac ksiazke do czytane teraz
        if(polecenie==6){
            for(Map.Entry<Integer, Ksiazki> entry:biblioteczka.getBiblioteczka().entrySet()){
                Ksiazki ksiazka = entry.getValue();
                System.out.println("\t" + entry.getKey() + ". " + ksiazka.getTytul() + " " + ksiazka.getAutor());
            }
            System.out.print("Podaj klucz książki, którą chcesz dodać do czytane: ");
            int input = scanner.nextInt();
            System.out.print("Podaj datę startu (wzór: dd.mm.yyyy): ");
            Date dateStart = formatter.parse(br.readLine());
            Czytane new_czytane = new Czytane(biblioteczka.getBiblioteczka().get(input), dateStart);
            biblioteczka.getBiblioteczka().get(input).getCzy_czytane().add(new_czytane);
        }

        //dodac ksiazke do przeczytanych
        if(polecenie==7) {
            System.out.println("Lista czytanych teraz ksiek: ");
            for (Map.Entry<Integer, Ksiazki> entry : biblioteczka.getBiblioteczka().entrySet()) {
                Ksiazki ksiazka = entry.getValue();
                if (!entry.getValue().getCzy_czytane().isEmpty() && entry.getValue().getCzy_przeczytane().isEmpty()) {
                    System.out.println("\t" + entry.getKey() + ". " + ksiazka.getTytul() + " " + ksiazka.getAutor());
                }
            }
            System.out.print("Podaj klucz książki z czytanych książek, którą przeczytałe(-a)ś:");
            int input = scanner.nextInt();
            System.out.print("Podaj datę końca (wzór: dd.mm.yyyy): ");
            Date dateEnd = formatter.parse(br.readLine());
            Przeczytane new_przeczytane = new Przeczytane(biblioteczka.getBiblioteczka().get(input),dateEnd);
            System.out.print("Czy spodobała ci się ta książka? (like tak/nie): ");
            String czy_ulubiona;
            boolean love;
            do{
                czy_ulubiona = scanner.nextLine();
                if(czy_ulubiona.equals("tak")) {
                    love = true;
                    new_przeczytane.setCzy_ulubiona(love);
                    }
                    else {
                        love = false;
                        new_przeczytane.setCzy_ulubiona(love);
                    }
            } while(czy_ulubiona.length()==0);

            biblioteczka.getBiblioteczka().get(input).getCzy_przeczytane().add(new_przeczytane);

        }

        //zobaczyc opinie o podanej ksiazce
        if(polecenie==8){
            for(Map.Entry<Integer, Ksiazki> entry:biblioteczka.getBiblioteczka().entrySet()){
                Ksiazki ksiazka = entry.getValue();
                System.out.println("\t" + entry.getKey() + ". " + ksiazka.getTytul() + " " + ksiazka.getAutor());
            }
            System.out.print("Podaj klucz ksiazki: ");
            int kl=scanner.nextInt();
            File odczyt_op = new File("C:\\Users\\zhuko\\IdeaProjects\\projekt\\" + biblioteczka.getBiblioteczka().get(kl).getTytul() + ".txt");
            if(!odczyt_op.exists()){
                System.out.println("Blad, nie ma opinii o tej ksiazce");
            }
            else if(!odczyt_op.canRead()){
                System.out.println("Blad, bie ma dostepu odczytu tego pliku");
            }
            else{
                BufferedReader fin = new BufferedReader(new FileReader(odczyt_op));
                String line;
                while((line = fin.readLine()) != null){
                    System.out.println(line);
                }
                fin.close();
            }
        }

        //napisac opinie o podanej ksiazce
        if(polecenie==9){
            for(Map.Entry<Integer, Ksiazki> entry:biblioteczka.getBiblioteczka().entrySet()){
                Ksiazki ksiazka = entry.getValue();
                System.out.println("\t" + entry.getKey() + ". " + ksiazka.getTytul() + " " + ksiazka.getAutor());
            }
            System.out.print("Podaj klucz ksiazki, opinie o jakiej chcesz napisac: ");
            int kl = scanner.nextInt();
            File zapis_op = new File("C:\\Users\\zhuko\\IdeaProjects\\projekt\\" + biblioteczka.getBiblioteczka().get(kl).getTytul() + ".txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(zapis_op));
            String text;
            do{
                text = scanner.nextLine();
            } while (text.length()==0);
            writer.write(text);
            writer.close();
        }

        //zobaczyc liste ksiazek do kupienia
        if(polecenie==10){
            System.out.println("Lista \"Ksiazki do kupienia\"");
            int k_il=do_kupienia.size();

            if(k_il==0){
                System.out.println("Niestety dopoki ta lista jest pusta((");
            }
            int kup;
            for(kup=0;kup < do_kupienia.size();kup++){
                System.out.println("\t" + "\"" + do_kupienia.get(kup).getTytul()
                        + "\" " + do_kupienia.get(kup).getAutor()
                        + ", " + do_kupienia.get(kup).getGatunek()
                        + ", " + do_kupienia.get(kup).getOslona() + " oslona");
            }
        }

        //dodac do listy kupic
        if(polecenie==11){
            Kupic new_kupic = new Kupic();

            String tytul;
            System.out.print("Wpisz tytul książki, jaką chcesz kupić: ");
            do{tytul = scanner.nextLine();}
                while(tytul.length()==0);
            new_kupic.setTytul(tytul);

            System.out.print("Wpisz autora \"" + tytul + "\": ");
            String autor = scanner.nextLine();
            new_kupic.setAutor(autor);

            System.out.print("Jaki jest gatunek \"" + tytul + "\"?: ");
            String gatunek = scanner.nextLine();
            new_kupic.setGatunek(gatunek);

            System.out.print("W jakie osonie chcial(-a)bys: (like twarda/miekka); ");
            String oslona = scanner.nextLine();
            new_kupic.setOslona(oslona);

            do_kupienia.add(new_kupic);
        }

        //wyswietlenie kategorii
        if(polecenie==12){
            System.out.println("Dostepne wyswietlania wg kategorii: " +
                    "\n\t1. ulubione ksiazki" +
                    "\n\t2. wyswietlic wszystkie informacje o ksiazkach w biblioteczce");
            int wk= scanner.nextInt();

            if (wk==1){
                for(Map.Entry<Integer, Ksiazki> entry:biblioteczka.getBiblioteczka().entrySet()){
                    Ksiazki ksiazka = entry.getValue();
                    for(Przeczytane przeczytane: ksiazka.getCzy_przeczytane()){
                        if(przeczytane.czy_ulubiona){

                            System.out.println("\t " + ksiazka.getTytul()
                            + " " + ksiazka.getAutor());
                        }
                    }
                }
            }
            }



        //wyswietlenie statystyki
        if(polecenie==13){
            System.out.println("Dostepne statystyki: " +
                    "\n\t1. Ile ksiazek o podanym autorze" +
                    "\n\t2. Ile razy czytales podana ksiazke");
            int sw = scanner.nextInt();
            if(sw==1){
                for(Map.Entry<Integer, Ksiazki> entry:biblioteczka.getBiblioteczka().entrySet()) {
                    Ksiazki ksiazka = entry.getValue();
                    System.out.println(ksiazka.getAutor());
                    for(Map.Entry<Integer, Ksiazki> entry0:biblioteczka.getBiblioteczka().entrySet()){
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
                    for (Map.Entry<Integer, Ksiazki> entry : biblioteczka.getBiblioteczka().entrySet()) {
                        Ksiazki ksiazka = entry.getValue();
                        if (ksiazka.getAutor().equals(pod_aut)) {
                            System.out.println(p++ + ". " + ksiazka.getTytul());
                        }
                    }
                    System.out.println("Czyli jest " + p + " ksiazek w biblioteczce o autorze " + pod_aut);
            }
            if(sw==2){
                for(Map.Entry<Integer, Ksiazki> entry:biblioteczka.getBiblioteczka().entrySet()){
                    Ksiazki ksiazka = entry.getValue();
                    System.out.println("\t" + entry.getKey() + ". " + ksiazka.getTytul() + " " + ksiazka.getAutor());
                }
                System.out.print("Podaj klucz ksiazki: ");
                int kl = scanner.nextInt();
                int p=0;
                Ksiazki ksiazka = biblioteczka.getBiblioteczka().get(kl);
                System.out.println(ksiazka.getTytul() + " byla przeczytana: ");
                for(Przeczytane przeczytana: ksiazka.getCzy_przeczytane()){
                    System.out.println("\t" + p++ + ". " + przeczytana.getEndDate());
                }
                System.out.println("Czyli przeczytale(-a)s " + p + "razy te ksiazke");
            }
        }

        //wateczek))
        if(polecenie==14){
            System.out.println("No coz, zdecydowale(-a)s na zabawke..(zabawka polega na tym, ze w miedzyczasie pojawia sie komunikat, jaka ksiazke chce przeczytac teraz. )");
            int size=biblioteczka.getBiblioteczka().size();

            for (int j = 1; j < 3; j++) {
                    int w = (int) (Math.random() * size);
                    Watek watek1 = new Watek(biblioteczka.getBiblioteczka().get(w));
                    watek1.start();
                    w=(int) (Math.random() * size);
                    Watek watek2 = new Watek(biblioteczka.getBiblioteczka().get(w % 3));
                    watek2.start();

                }

        }

        //wyjscie z programu
        if(polecenie==15){
            System.exit(0);
        }







    }
    }

}