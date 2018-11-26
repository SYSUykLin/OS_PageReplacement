import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;

public class Algorithm {

    public static boolean hit(int[] arr, int v){
        for (int i = 0; i < arr.length; i ++){
            if (arr[i] == v){
                return false;
            }
        }
        return true;
    }


    public static boolean hit(Map<Integer, Integer> map, int v){
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getKey() == v){
                return false;
            }
        }
        return true;
    }

    public static boolean full(int[] arr){
        for (int i = 0; i < arr.length; i ++){
            if (arr[i] == -1){
                return false;
            }
        }
        return true;
    }

    public static double FIFO(Vector<Integer> vector, int PageSize){
        int [] arr =  new int[PageSize];
        int count = 0;
        boolean full = false;
        int j = 0;
        for (int i = 0; i < PageSize; i ++){
            arr[i] = -1;
        }
        for (int v : vector) {
            v /= 10;
//            for (int i = 0; i < PageSize; i++) {
//                System.out.print(arr[i] + " ");
//            }
//            System.out.println();
            if (hit(arr, v)){
                if (full == false){
                    arr[j] = v;
                    count ++;
                    j = (j+1)%PageSize;
                    full = full(arr);
                    if (full == true){
                        j = 0;
                    }
                }
                else {
                    arr[j] = v;
                    j = (j+1)%PageSize;
                }
            }else {
                count ++;
            }
        }
        return count;
    }

    public static Map<Integer, Integer> getPriority(Vector<Integer> vector, Map<Integer, Integer> map, int i){
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            for (int j = i+1; j < vector.size(); j++) {
                if (entry.getKey() == vector.get(j)/10){
                    map.replace(entry.getKey(), j);
                    break;
                }
                map.replace(entry.getKey(), vector.size());
            }
        }
        return map;
    }

    public static int LRU(Vector<Integer> vector, int PageSize){
        Map<Integer, Integer> map = new LinkedHashMap<>(PageSize);
        int count = 0;
        //int j = 0;
        for (int i = 0; i < vector.size(); i++) {
            Integer v = vector.get(i);
            v /= 10;
            //System.out.println(map);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()){
                map.put(entry.getKey(), entry.getValue()+1);
            }
            if (hit(map, v)){
                if (map.size() < PageSize){
                    count ++;
                    map.put(v, 0);
                }else {

                    int maxKey = 0;
                    int  maxValue = 0;
                    for (Map.Entry<Integer, Integer> entry : map.entrySet()){

                        if (entry.getValue() > maxValue){
                            maxValue = entry.getValue();
                            maxKey = entry.getKey();
                        }
                    }
                    //System.out.println(map);
                    //System.out.println(maxKey);
                    map.remove(maxKey);
                    map.put(v, 0);
                }
            }else {
                count ++;
                map.replace(v, 0);
            }
        }
        //System.out.println(count);
        return count;
    }

    public static int OPT(Vector<Integer> vector, int PageSize){
        Map<Integer, Integer> map = new LinkedHashMap<>(PageSize);
        int count = 0;
        for (int i = 0; i < vector.size(); i++) {
            Integer v = vector.get(i);
            v /= 10;
            //System.out.println(map);
            if (hit(map, v)){
                if (map.size() < PageSize){
                    count ++;
                    map.put(v, 0);
                }else {
                    map = getPriority(vector, map, i);
                    //System.out.println(map);
                    //System.out.println(map);
                    int maxKey = 0;
                    int  maxValue = 0;
                    for (Map.Entry<Integer, Integer> entry : map.entrySet()){

                        if (entry.getValue() > maxValue){
                            maxValue = entry.getValue();
                            maxKey = entry.getKey();
                            //System.out.println(entry);
                        }
                    }
//                    System.out.println(map);
//                    System.out.println(maxKey);
//                    System.out.println("V : " + v);
                    map.remove(maxKey);
                    map.put(v, 0);
                }
            }else {
                count ++;
                //map.replace(v, 0);
            }
        }
        //System.out.println(count);
        return count;
    }
}
