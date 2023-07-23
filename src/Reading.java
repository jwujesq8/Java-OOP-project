import java.io.Serializable;
import java.util.Date;

public class Reading implements Serializable {
    private int booksId;
    private Date startDate;

    public Reading() {
    }

    public Date getStartDate() {
        return startDate;
    }

    public int getBooksId() {
        return booksId;
    }
    public void changeBooksId(int newId){
        this.booksId = newId;
    }

    public Reading(int id, Date startDate){
        this.booksId=id;
        this.startDate=startDate;
    }

}
