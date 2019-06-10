import java.util.Scanner;

public class Error {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        int serverNum = Integer.parseInt(firstLine);
        int[] arr = new int[serverNum];
        int total = 0;
        for (int i = 0; i < serverNum; i++)
        {
            String[] tmp = scanner.nextLine().split(" ");
            int tmp0 = Integer.parseInt(tmp[0]);
            int tmp1 = Integer.parseInt(tmp[1]);
            arr[i] = tmp0 * tmp1;
            total += arr[i];
        }
        for (int i = 0; i < serverNum; i++){
            System.out.printf("%.12f\n", (double)arr[i] / total);
        }

    }
}
