
import java.util.Random;

public class Animacion extends Thread{
    public int lastNumber = -1; 
    public int newNumber;

    private Random random = new Random();

    private Mole mole;
    public int[][] molePositions = {
        {120, 80},
        {360, 120},
        {600, 90},
        {90, 280},
        {360, 320},
        {640, 290},
    };

    public Animacion(Mole mole){
        this.mole = mole;
    }

    public void setMolePosition(){
        do {
            newNumber = random.nextInt(5); 
        } while (newNumber == lastNumber); 
        
        lastNumber = newNumber; 
    }

    @Override
    public void run(){

        while(true){
            try {
                setMolePosition();
                mole.getMolePosition(molePositions[newNumber][0], molePositions[newNumber][1]);
                sleep(1100);
            } catch (InterruptedException ex) {
            }

        }
        

    }
}
