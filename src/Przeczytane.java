import java.io.Serializable;
import java.util.Date;

public class Przeczytane implements Serializable {
    Ksiazki ksiazka;
    private Date endDate;
    boolean czy_ulubiona;

    public Ksiazki getKsiazka(){
        return ksiazka;
    }

    public Date getEndDate() {
        return endDate;
    }

    public boolean getCzy_ulubiona(){
        return czy_ulubiona;
    }

    public void setCzy_ulubiona(boolean czy_ulubiona) {
        this.czy_ulubiona = czy_ulubiona;
    }

    public Przeczytane(Ksiazki ksiazka, Date endDate, boolean czy_ulubiona) {
        this.ksiazka=ksiazka;
        this.endDate = endDate;
        this.czy_ulubiona = czy_ulubiona;
    }
    public Przeczytane(Ksiazki ksiazka, Date endDate) {
        this.ksiazka=ksiazka;
        this.endDate = endDate;
    }
}