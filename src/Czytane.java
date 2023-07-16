import java.io.Serializable;
import java.util.Date;

public class Czytane implements Serializable {
    private Ksiazki ksiazka;
    private Date startDate;

    public Czytane() {
    }

    public Date getStartDate() {
        return startDate;
    }

    public Ksiazki getKsiazka() {
        return ksiazka;
    }

    public Czytane(Ksiazki ksiazka, Date startDate){
        this.ksiazka=ksiazka;
        this.startDate=startDate;
    }

}
