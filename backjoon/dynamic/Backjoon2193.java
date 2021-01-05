package backjoon.dynamic;

import java.io.*;

public class Backjoon2193 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;
    private static long arr[];

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = new long[N + 1];
        arr[0] = 0;
        arr[1] = 1;
        
        for(int i = 2; i <= N; i++){
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        bw.write(arr[N] + "\n");
        bw.close();
        br.close();
    }
}
