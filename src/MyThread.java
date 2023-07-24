import java.util.List;

public class MyThread extends Thread{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";
    public static final String YELLOW_BOLD = "\033[1;33m";

    private Library library;
    public MyThread(Library library){
        this.library = library;
    }

    @Override
    public void run(){
        for(int i=0;i<3;i++){
            int randomId = (int) (Math.random() * library.getSize());
            Book randomBook = library.getLibrary().get(randomId);
            System.out.println(YELLOW_BOLD_BRIGHT + "\n\t\t\t\t\tIDEA!!! maybe I should read \"" + randomBook.getTitle() + "\".." + ANSI_RESET);
            if(i<2){
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
            }
        }
        System.out.println(YELLOW_BOLD + "\t\t\t\t\tend of the toy" +ANSI_RESET);


    }
}
