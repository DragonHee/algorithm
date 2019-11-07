package backjoon.backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class Backjoon15649 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int n;
    private static int m;
    private static int[] arr;
    private static boolean isCheck[];

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        isCheck = new boolean[n + 1];
        arr = new int[m + 1];

        solve(1);
        bw.close();
        br.close();
    }

    public static void solve(int cnt) throws IOException {
        if(cnt - 1 == m) {
            for(int i = 1; i <= m; i++) bw.write(arr[i] + " ");
            bw.write("\n");
            return;
        }
        for(int i = 1 ; i <= n; i++){
            if(!isCheck[i]){
                arr[cnt] = i;
                isCheck[i] = true;
                solve(cnt + 1);
                isCheck[i] = false;
            }
        }
    }

}
