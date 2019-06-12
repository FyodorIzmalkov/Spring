import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Graph {
    public static void printMap(HashMap<Integer, List<Integer>> map){
        for (Integer key: map.keySet()){
            List list = map.get(key);
            for (int l = 0; l < list.size(); l++){
                System.out.print(list.get(l));
                if (l >= 0 && l < list.size() - 1)
                    System.out.print(" ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        String[] firstLineArray = firstLine.split(" ");
        int numOfVerticies = Integer.parseInt(firstLineArray[0]);
        int numOfEdges = Integer.parseInt(firstLineArray[1]);
        if (numOfEdges <= 0 || numOfVerticies <= 0){
            System.out.println("-1");
            System.exit(0);
        }
        HashMap<Integer, Integer> allPeople = new HashMap<>();
        int i = 1;
        while (i <= numOfVerticies){
            allPeople.put(i, numOfVerticies);
            i++;
        }
        HashMap<Integer, List<Integer>> teamA= new HashMap<>();
        HashMap<Integer, List<Integer>> teamB= new HashMap<>();
        int numOfPairs = 0;
        i = 1;
        int j = 1;
        int numInTeamA = 0;
        while(numOfEdges > 0){
            String[] lineArray = scanner.nextLine().split(" ");
            int first = Integer.parseInt(lineArray[0]);
            int second = Integer.parseInt(lineArray[1]);
            List <Integer> list = new ArrayList<>();
            list.add(first);
            list.add(second);
            if (teamA.size() <= teamB.size()) {
                teamA.put(i, list);
                i++;
                numInTeamA += 2;
            }
            else{
                teamB.put(j, list);
                j++;
            }
            allPeople.remove(first);
            allPeople.remove(second);
            --numOfEdges;
        }
        for (Integer key: allPeople.keySet()){
            List <Integer> list = new ArrayList<>();
            list.add(allPeople.get(key));
            if (teamA.size() <= teamB.size()) {
                teamA.put(i, list);
                i++;
                numInTeamA++;
            }
            else{
                teamB.put(j, list);
                j++;
            }
        }
        System.out.println(numInTeamA);
        printMap(teamA);
        System.out.println();
        printMap(teamB);
    }
}
