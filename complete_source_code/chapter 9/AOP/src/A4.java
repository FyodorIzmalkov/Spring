import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int w = Integer.parseInt(bufferedReader.readLine());
        if (w < 4 || w % 2 != 0)
            System.out.println("NO");
        else
            System.out.println("YES");
    }
}