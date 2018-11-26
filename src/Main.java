import java.text.DecimalFormat;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        Vector<Integer> vector = Tool.initialAddr(400);
        System.out.println(vector);
        System.out.println("    FIFO    LRU    OPT");
        for (int i = 4; i <= 40; i++) {
            DecimalFormat df = new DecimalFormat("#0.00");
            System.out.println(i + " : " + df.format(Algorithm.FIFO(vector, i)/400.00) + "   " + df.format(Algorithm.LRU(vector, i)/400.00) + "   " + df.format(Algorithm.OPT(vector, i)/400.0));
            //break;
        }
    }
}
