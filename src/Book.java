import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Book implements Serializable {
    public String title;
    public String author;
    public String genre;
    public Book(){}


    Pattern a = Pattern.compile("[A-z ]{1,100}");

    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getGenre(){
        return genre;
    }


        public void setTitle(String title){
            if(title.length()!=0){
                this.title = title;
            }
        }
        public void setAuthor(String author){
            Matcher A = a.matcher(author);
            if(A.matches()){
                this.author = author;
            }
            else System.out.println("Entered author is wrong..");
        }
        public void setGenre(String genre){
            Matcher G = a.matcher(genre);
            if(G.matches()){
                this.genre = genre;
            }
        }
    public Book(String title, String author){
        setTitle(title);
        setAuthor(author);
    }
    public Book(String title, String author, String genre){
        setTitle(title);
        setAuthor(author);
        setGenre(genre);
    }



}