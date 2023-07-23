import java.io.Serializable;
import java.util.Date;

public class Read implements Serializable {
    int booksId;
    private Date startDate;
    private Date endDate;
    boolean isItFavorite;

    public int getBooksId(){
        return booksId;
    }
    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public boolean isItFavorite(){
        return isItFavorite;
    }

    public void setIsItFavorite(boolean like) {
        this.isItFavorite = like;
    }

    public Read(Reading readingInfo, Date endDate, boolean like) {
        this.booksId=readingInfo.getBooksId();
        this.startDate = readingInfo.getStartDate();
        this.endDate = endDate;
        this.isItFavorite = like;
    }
    public Read(Reading readingInfo, Date endDate) {
        this.booksId=readingInfo.getBooksId();
        this.startDate = readingInfo.getStartDate();
        this.endDate = endDate;
    }

    public Read(int id, Date startDate, Date endDate, boolean like) {
        this.booksId=id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isItFavorite = like;
    }
    public Read(int id, Date startDate, Date endDate) {
        this.booksId=id;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public void changeBooksId(Read readBook, int newId){
        readBook.booksId = newId;
    }
}