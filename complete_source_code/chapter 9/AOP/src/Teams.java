import java.util.Scanner;

public class Teams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstTeamScore = 0;
        int secondTeamScore = 0;
        boolean flag = true;
        while (flag){
            System.out.println("Input score for the first team. Input 0 for end. Input 4 to switch to second team.");
            int tmp = scanner.nextInt();
            if (tmp == 0) {
                flag = false;
                System.out.println("Final score: " + firstTeamScore + " : " + secondTeamScore);
                break;
            }
            else {
                if (tmp == 4)
                    firstTeamScore += 0;
                else {
                    firstTeamScore += tmp;
                    System.out.println("Score is: first " + firstTeamScore + " : second " + secondTeamScore);
                }
            }
            System.out.println("Input score for the second team. Input 0 for end. Input 4 to switch to first team.");
            tmp = scanner.nextInt();
            if (tmp == 0){
                flag = false;
                System.out.println("Final score: " + firstTeamScore + " : " + secondTeamScore);
                break;
            }
            else {
                if (tmp == 4)
                    secondTeamScore += 0;
                else {
                    secondTeamScore += tmp;
                    System.out.println("Score is: first " + firstTeamScore + " : second " + secondTeamScore);
                }
            }
        }
    }
}
