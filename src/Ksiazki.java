import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ksiazki implements Serializable {
    public String tytul;
    public String autor;
    public String gatunek;
    public List<Czytane> czy_czytane = new ArrayList<>();
    public List<Przeczytane> czy_przeczytane = new ArrayList<>();
    public Ksiazki(){

    }

    Pattern a = Pattern.compile("[A-z ]{1,100}");

    public String getTytul(){
        return tytul;
    }
    public String getAutor(){
        return autor;
    }
    public String getGatunek(){
        return gatunek;
    }
    public List<Czytane> getCzy_czytane(){return czy_czytane; }

    public List<Przeczytane>  getCzy_przeczytane(){return czy_przeczytane; }


        public void setTytul(String tytul){
            if(tytul.length()!=0){
                this.tytul=tytul;
            }
        }
        public void setAutor(String autor){
            Matcher A = a.matcher(autor);
            if(A.matches()){
                this.autor=autor;
            }
            else System.out.println("Wpisałe(-a)ś niepoprawnie autora");
        }
        public void setGatunek(String gatunek){
            Matcher G = a.matcher(gatunek);
            if(G.matches()){
                this.gatunek=gatunek;
            }}



}