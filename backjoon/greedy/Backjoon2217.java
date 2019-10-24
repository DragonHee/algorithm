package backjoon.greedy;

import java.io.*;
import java.util.Arrays;

public class Backjoon2217 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        long max = Long.MIN_VALUE;

        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        for(int i = 0; i < n; i++){
            max = (arr[i] * (n - i)) > max ? arr[i] * (n - i) : max;
        }
        bw.write(max + "\n");
        bw.close();
        br.close();
    }
}
