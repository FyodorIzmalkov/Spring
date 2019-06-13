import java.lang.reflect.Array;
import java.util.*;

public class Mult {

     public static int getInt(String str){
        return Integer.parseInt(str);
    }

    public static int getMax(HashMap<Integer, List <Integer>> map, HashMap<Integer, Integer> results){
         int max = -1;
         int key = 0;
        for (Map.Entry<Integer, List <Integer>> first : map.entrySet()) {
            if (max == -1) {
                max = first.getValue().get(0);
                key = first.getKey();
            }
            else if (first.getValue().get(0) > max)
                max = first.getValue().get(0);
                key = first.getKey();
        }
        results.put(key, max);
        map.remove(key);
        return max;
    }

    public static void getOnes(HashMap<Integer, List <Integer>> map, HashMap<Integer, Integer> results){
        for (Map.Entry<Integer, List <Integer>> first : map.entrySet()) {
            if (first.getValue().get(0) == 1){
                int key = first.getKey();
                results.put(key, 1);
                map.remove(key);
                return;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstArr = scanner.nextLine().split(" ");
        int N = getInt(firstArr[0]);
        int M = getInt(firstArr[1]);
        int K = getInt(firstArr[2]);
        String[] secondArr = scanner.nextLine().split(" ");
        List<Integer> intArray = new ArrayList<Integer>();
        for (String str : secondArr) {
            intArray.add(getInt(str));
        }
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int in : intArray) {
            if (M % in == 0) {
                int index = intArray.indexOf(in) + 1;
                List<Integer> list = new ArrayList<>();
                list.add(in);
                map.put(index, list);
            }
        }
        int max = -1;
        HashMap<Integer, Integer> results = new HashMap<>();
        boolean flag = true;
        int size = map.size();
        int iterator = 1;
        while (flag) {
            int num = map.get(iterator).get(0);
            int key = iterator;
            int tmp = M;
            int counter = 0;
            int numberOfOnes=0;
            for (Map.Entry<Integer, List<Integer>> first : map.entrySet()) {
                    int key2 = first.getKey();
                    if (key != key2)
                        num = first.getValue().get(0);
                    if (tmp % num == 0 && num != 1) {
                            tmp /= num;
                            System.out.println(num);
                            counter++;
                    }
                    if (num == 1)
                        numberOfOnes++;
                    if (counter == K) {
                        flag = false;
                        break;
                    }
                    else if (tmp == 1 && (numberOfOnes >= K - counter)){
                        flag = false;
                        break;
                    }
//            if (tmp == M){
//                while (counter != K){
//                    getOnes(map, results);
//                    counter++;
//                }
//                break;
//            }
//            max = getMax(map, results);
//            tmp *= max;
//            counter++;
//            if (counter == K)
//                break;
                }
            iterator++;
            if (iterator > size)
                break;
            }
        }
//        for (Map.Entry<Integer, Integer> first : results.entrySet()) {
//            System.out.println(first.getKey() + " : " + first.getValue());
//        }
    }
