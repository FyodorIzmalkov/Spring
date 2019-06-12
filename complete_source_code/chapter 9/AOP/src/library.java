import java.util.Scanner;

public class library {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(" ");
        int dayliLimitOfBooks = Integer.parseInt(arr[0]);
        int numOfBooksAtHome = Integer.parseInt(arr[1]);
        int dayOfWeek = Integer.parseInt(arr[2]);
        int wantToReadToday = 1;
        int result = 0;
        while (true){
            if (dayOfWeek <= 5)
                numOfBooksAtHome += dayliLimitOfBooks;
            numOfBooksAtHome -= wantToReadToday;
            if (numOfBooksAtHome < 0){
                System.out.println(result);
                System.exit(0);
            }
            if (dayOfWeek == 7)
                dayOfWeek = 1;
            else
                dayOfWeek++;
            result++;
            wantToReadToday++;
        }
    }
}
