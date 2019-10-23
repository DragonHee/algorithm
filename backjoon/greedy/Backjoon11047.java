package backjoon.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class Backjoon11047 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int [] arr = new int[n + 1];
        int answer = 0;

        for(int i = 1; i <= n; i++) arr[i] = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            answer += k / arr[n - i];
            k %= arr[n - i];
        }

        bw.write(answer + "\n");
        bw.close();
        br.close();
    }
}
