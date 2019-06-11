import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Meetings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfStrings = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> daysMap = new HashMap<String, List<String>>();
        byte flag = 0;
        byte printed = 0;
        for (int i = 0; i < numOfStrings; i++){
            flag = 0;
            printed = 0;
            String nextLine = scanner.nextLine();
            String[] tmp = nextLine.split(" ");
            if (tmp[0].equals("APPOINT")){
                if (daysMap.containsKey(tmp[1])){
                    List<String> tmpList =  daysMap.get(tmp[1]);
                    int size = tmpList.size();
                    for (int j = 0; j < size; j++){
                        if (flag == 1)
                            break;
                        String[] daysTmp = tmpList.get(j).split(" ");
                        for (int k = 5; k < tmp.length; k++)
                        {
                            if (daysTmp[k].equals(tmp[k])){
                                String[] time = daysTmp[2].split(":");
                                int hours = Integer.parseInt(time[0]);
                                int mins = Integer.parseInt(time[1]);
                                int start = hours * 60 + mins;
                                int end = start + Integer.parseInt(daysTmp[3]);

                                String[] newTime = tmp[2].split(":");
                                int newHours = Integer.parseInt(newTime[0]);
                                int newMins = Integer.parseInt(newTime[1]);
                                int newStart = newHours * 60 + newMins;
                                if (newStart >= start || newStart <= end){
                                    System.out.println("FAIL");
                                    for (int l = 5; l < tmp.length; l++){
                                        System.out.print(tmp[l]);
                                        if (l + 1 != tmp.length)
                                            System.out.print(" ");
                                        else
                                            System.out.println();
                                    }
                                    printed = 1;
                                    flag = 1;
                                    break;
                                }
                            }
                        }
                    }
                    if (flag != 1) {
                        tmpList.add(nextLine);
                        daysMap.put(tmp[1], tmpList);
                    }
                    if (printed == 0)
                        System.out.println("OK");
                }
                else{
                    List <String> tmpList = new ArrayList<String>();
                    tmpList.add(nextLine);
                    daysMap.put(tmp[1],tmpList);
                    System.out.println("OK");
                }

            }
            else
            {
                Map <Integer, String> map = new HashMap<>();
                if (daysMap.containsKey(tmp[1])){
                    List<String> dayTmpList = daysMap.get(tmp[1]);
                    for (String item: dayTmpList){
                        String[] currentLine = item.split(" ");
                        for (String linePart: currentLine){
                            if (linePart.equals(tmp[2])){
                                String[] time = currentLine[2].split(":");
                                Integer key = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
                                String str = "" + currentLine[2] + " " + currentLine[3] + " ";
                                int numOfPersons = Integer.parseInt(currentLine[4]);
                                for (int z = 0; z < numOfPersons; z++){
                                    str += currentLine[5 + z];
                                    if ( z + 1 != numOfPersons)
                                        str += " ";
                                }
                                map.put(key, str);
                            }
                        }
                    }
                    TreeMap<Integer, String> sorted = new TreeMap<>();
                    sorted.putAll(map);
                    for (Map.Entry<Integer, String> entry: sorted.entrySet()){
                        System.out.println(entry.getValue());
                    }
                }

            }

        }
    }
}
