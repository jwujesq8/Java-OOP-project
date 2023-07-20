import java.util.List;

public class MyThread extends Thread{

    private Book book;
    private List<Read> readList;
    public MyThread(Book book, List<Read> list){
        this.book = book;
        this.readList = list;
    }

    @Override
    public void run(){
        for(int i=1;i<3;i++){
            if(readList.contains(book)){
                System.out.println("\n\t\t\t\t\tIDEA!!! maybe I should read this book again \"" + book.getTitle() + "\"..");
            } else{
                System.out.println("\n\t\t\t\t\tmaybe I should start reading a new book, for example \"" + book.getTitle() + "\"..");
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
