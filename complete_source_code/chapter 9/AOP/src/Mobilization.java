import org.springframework.core.annotation.Order;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class Mobilization {

    static class Participant{
        int devSkill;
        int manSkill;
        int difference;

        Participant(int devSkill, int manSkill){
            this.devSkill = devSkill;
            this.manSkill = manSkill;
            this.difference = devSkill - manSkill;
        }

        public void calculateDifference(){
            this.difference = this.devSkill - this.manSkill;
        }

        public String toString(){
            return "Participants devSkill: " + devSkill + " manSkill: " + manSkill;
        }

    }

    static public Map<Integer, Integer> sortMapByValue(Map<Integer, Integer> map){
        Map <Integer, Integer> sortedDifferences = map.entrySet().stream().sorted(comparingByValue()).collect(
                Collectors.toMap(e->e.getKey(), e->e.getValue(), (e1, e2)-> e2, LinkedHashMap::new));
        return sortedDifferences;
    }

    static public int getInteger(String str){
        return Integer.parseInt(str);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfUsers = Integer.parseInt(scanner.nextLine());
        int teamSize = numOfUsers / 2;
        String[] developerSkill = scanner.nextLine().split(" ");
        String[] managementSkill = scanner.nextLine().split(" ");
        Map<Integer, Integer> differences = new HashMap<>();
        List<Participant> allParticipants = new ArrayList<>();
        List<Participant> devTeam = new ArrayList<>();
        List<Participant> manTeam = new ArrayList<>();
        for (int i = 0; i < numOfUsers; i++){
            Participant participant = new Participant(Integer.parseInt(developerSkill[i]), Integer.parseInt(managementSkill[i]));
            differences.put(i, participant.difference);
            allParticipants.add(participant);
        }
        int numOfSertificates = Integer.parseInt(scanner.nextLine());
        while (numOfSertificates > 0){
            String[] sertArr = scanner.nextLine().split(" ");
            int participitianNum = getInteger(sertArr[0]) - 1;
            int skillNum = getInteger(sertArr[1]);
            int skillChange = getInteger(sertArr[2]);
            Participant tmp = allParticipants.get(participitianNum);
            if (skillNum == 1){
                tmp.devSkill += skillChange;
                tmp.calculateDifference();
            }
            else{
                tmp.manSkill += skillChange;
                tmp.calculateDifference();
            }
            differences.put(participitianNum, tmp.difference);
            Map <Integer, Integer> sortedDifferences = sortMapByValue(differences);
            int i = 1;
            if (!manTeam.isEmpty() && !devTeam.isEmpty()){
                manTeam.clear();
                devTeam.clear();
            }
            for (Map.Entry<Integer, Integer> entry: sortedDifferences.entrySet()){
                if (i <= teamSize) {
                    manTeam.add(allParticipants.get(entry.getKey()));
                    i++;
                }
                else
                    devTeam.add(allParticipants.get(entry.getKey()));
            }
            int total = 0;
            for (Participant part: devTeam)
                total += part.devSkill;
            for (Participant part: manTeam)
                total += part.manSkill;
            System.out.println(total);
            --numOfSertificates;
        }
    }

}
