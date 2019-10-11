package backjoon.dynamic;

import java.io.*;
import java.util.StringTokenizer;

public class Backjoon1932 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int [][] arr;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[n + 1][n + 1];
        int max;

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= i; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                arr[i][j] += max(arr[i - 1][j], arr[i - 1][j - 1]);
            }
        }
        max = arr[n][1];
        for(int i = 2; i <=n; i++){
            if(max < arr[n][i]) max = arr[n][i];
        }
        bw.write(max + "\n");
        bw.close();
        br.close();
    }
    private static int max(int a, int b){
        return (a > b) ? a : b;
    }
}
