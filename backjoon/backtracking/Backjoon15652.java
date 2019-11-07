package backjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class Backjoon15652 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int m, n;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m + 1];
        solve(1);
        bw.close();
        br.close();
    }

    public static void solve(int cnt) throws IOException {
        if(cnt - 1 == m){
            for(int i = 1; i <= m; i++) bw.write(arr[i] + " ");
            bw.write("\n");
            return;
        }
        for(int i = 1; i <= n; i++){
            if(arr[cnt - 1] <= i){
                arr[cnt] = i;
                solve(cnt + 1);
            }
        }
    }
}
