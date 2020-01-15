package backjoon.divideandconquer;

import java.io.*;
import java.util.Arrays;
// 10의 n승 -> 15 * 10^(n - 1)
public class Backjoon2749 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        long n = Long.parseLong(br.readLine());
        int[] arr = new int[3];
        arr[0] = 0;
        arr[1] = 1;

        long period = 1_500_000;
        long a = n % period;

        for(long i = 2; i <= a; i++) {
            arr[2] = (arr[0] + arr[1]) % 1_000_000;
            arr[0] = arr[1];
            arr[1] = arr[2];
        }
        if(n == 0) bw.write(0 + "");
        else bw.write(arr[1] + "");

        bw.close();
        br.close();
    }
}
