import java.util.Random;
import java.util.Vector;

public class Tool {
    public static Vector<Integer> initialAddr(int count){
        Vector<Integer> vector = new Vector<>();
        int number = 0;
        while (number < count){
            Random Random = new Random();
            int addr = Random.nextInt(200);
            vector.add(addr);
            vector.add(addr+1);
            addr = Random.nextInt(200) + 200;
            vector.add(addr);
            vector.add(addr+1);
            number += 4;
        }
        return vector;
    }
}
