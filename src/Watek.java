public class Watek extends Thread{

    private Ksiazki ksiazka;
    public Watek(Ksiazki ksiazka){
        this.ksiazka=ksiazka;
    }

    @Override
    public void run(){
        for(int i=1;i<4;i++){
            if(ksiazka.getCzy_przeczytane().isEmpty()){
                System.out.println("\n\t\t\t\t\tPOMYSL!!! byc moze zaczac czytac \"" + ksiazka.getTytul() + "\"");
            }
            else{
                System.out.println("\n\t\t\t\t\tPOMYSL!!! no byc moze jeszcze raz przeczytac \"" + ksiazka.getTytul() + "\"");
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
