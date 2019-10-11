package backjoon.dynamic;


import java.io.*;
import java.util.StringTokenizer;

public class Backjoon1149 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[][] paintArr;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        paintArr = new int[n + 1][3];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            paintArr[i][0] = Integer.parseInt(st.nextToken());
            paintArr[i][1] = Integer.parseInt(st.nextToken());
            paintArr[i][2] = Integer.parseInt(st.nextToken());
        }
        solve(n);
        bw.close();
        br.close();
    }
    private static void solve(int n) throws IOException {
        for(int i = 1; i <= n; i++){
            paintArr[i][0] = min(paintArr[i - 1][1], paintArr[i - 1][2]) + paintArr[i][0];
            paintArr[i][1] = min(paintArr[i - 1][0], paintArr[i - 1][2]) + paintArr[i][1];
            paintArr[i][2] = min(paintArr[i - 1][0], paintArr[i - 1][1]) + paintArr[i][2];
        }
        bw.write(min(min(paintArr[n][0], paintArr[n][1]),paintArr[n][2]) + "\n");
    }
    private static int min(int n, int m){
        return (m < n) ? m : n;
    }
}
