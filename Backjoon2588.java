import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Backjoon2588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        int firstCalc = a * ( b % 10);
        int secondCalc = a * (b % 100 / 10);
        int thirdCalc = a * (b / 100);

        System.out.println(firstCalc + "\n" + secondCalc + "\n" + thirdCalc + "\n" + (firstCalc + secondCalc * 10 + thirdCalc * 100));


    }
}
