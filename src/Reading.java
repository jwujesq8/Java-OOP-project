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

    public Reading(int id, Date startDate){
        this.booksId=id;
        this.startDate=startDate;
    }

}
