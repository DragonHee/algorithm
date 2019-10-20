package backjoon.dynamic;

import java.io.*;
import java.util.StringTokenizer;

class Matrix{
    int row;
    int column;
    public Matrix(int row, int column){this.row = row;this.column = column;}
    public int getRow(){return row;}
    public int getColumn(){return column;}
}
public class Backjoon11049 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static Matrix[] arr;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int i, j;
        arr = new Matrix[n + 1];
        dp = new int[n + 1][n + 1];
        StringTokenizer st;

        for(i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            arr[i] = new Matrix(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for(i = 1; i <= n - 1; i++){
            for(j = 1; j <= n - i; j++){
               getMin(j, j + i);
            }
        }

        bw.write(dp[1][n] + "\n");
        bw.close();
        br.close();
    }
    public static int min(int a, int b){return a > b ? b : a;}
    public static void getMin(int a, int b){
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < b - a; i++){
            min = min(min, dp[a][a + i] + dp[a + i + 1][b]
                    + arr[a].getRow() * arr[a + i].getColumn() * arr[b].getColumn());
        }

        dp[a][b] = min;
    }
}
