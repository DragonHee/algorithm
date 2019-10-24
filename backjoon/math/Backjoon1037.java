package backjoon.math;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon1037 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        bw.write(arr[1] * arr[n] + "\n");
        bw.close();
        br.close();
    }
}
