package backjoon.divideandconquer;

import java.io.*;
import java.util.StringTokenizer;

public class Backjoon2630 {
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] arr;
    static int zeroCnt = 0, oneCnt = 0;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        arr = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= n; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        solve(1,1,n);
        bw.write(zeroCnt + "\n" + oneCnt + "\n");
        bw.close();
        br.close();
    }
    public static void solve(int row, int col, int num){
        if(num == 1){
            for(int i = row; i < row + num; i++){
                for(int j = col; j < col + num; j++){
                    if(arr[i][j] == 1) oneCnt++;
                    else zeroCnt++;
                }
            }

            return;
        }
        int colorNum = 0;
        boolean flag = true;

        for(int i = row; i < row + num; i++){
            for(int j = col; j < col + num; j++){
                if(i == row && j == col) colorNum = arr[i][j];
                if(colorNum != arr[i][j]) flag = false;
            }
        }

        if(flag) {
            if(colorNum == 1) oneCnt++;
            else zeroCnt++;
        }
        else{
            solve(row, col, num / 2);
            solve(row, col + num / 2, num / 2);
            solve(row + num / 2, col, num / 2);
            solve(row + num / 2, col + num / 2, num / 2);
        }

    }

}
