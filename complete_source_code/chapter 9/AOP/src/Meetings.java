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
                    tmpList.add(nextLine);
                    daysMap.put(tmp[1], tmpList);
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

            }

        }
    }
}
