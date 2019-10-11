package backjoon.dynamic;

import java.io.*;

public class Backjoon9461 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static long[] arr;
    public static void main(String[] args) throws IOException {
        int testCnt = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < testCnt; i++){
            int n = Integer.parseInt(br.readLine());
            if(n >= 2) arr = new long[n + 1];
            else arr = new long[3];
            arr[1] = 1;
            arr[2] = 1;
            solve(n);
        }
        bw.close();
        br.close();
    }
    private static void solve(int n) throws IOException {
        for(int i = 3; i <= n; i++){
            arr[i] = arr[i - 2] + arr[i - 3];
        }
        bw.write(arr[n] + "\n");
    }
}
