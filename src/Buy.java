public class Buy extends Book{
    public String cover;

    public Buy(){}
    public Buy(Book book, String cover){
        this.title = book.title;
        this.author = book.author;
        this.genre = book.genre;
        this.cover = cover;
    }

    public void setCover(String c) {
        this.cover = c;
    }

    public String getCover() {
        return cover;
    }
}