import java.util.Scanner;

public class WayToZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCalls = Integer.parseInt(scanner.nextLine());
        while (numOfCalls > 0){
            String[] arr = scanner.nextLine().split(" ");
            long n = Long.parseLong(arr[0]);
            long k = Long.parseLong(arr[1]);
            long counter = 0;
            while (n != 0){
                if (n % k == 0){
                    n /= k;
                    counter++;
                }
                else{
                    counter += n % k;
                    n = n / k * k;
                }
            }
            --numOfCalls;
            System.out.println(counter);
        }
    }
}
