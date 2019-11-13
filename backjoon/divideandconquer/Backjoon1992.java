package backjoon.divideandconquer;

import java.io.*;

public class Backjoon1992 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int [][] arr;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++){
            String s = br.readLine();
            for(int j = 1; j <= n; j++){
                arr[i][j] = s.charAt(j - 1) - '0';
            }
        }

        solve(1,1,n);
        bw.close();
        br.close();
    }
    public static void solve(int r, int c, int n) throws IOException {
        if(n == 1){
            bw.write(arr[r][c] + "");
            return;
        }

        boolean flag = true;
        int num = arr[r][c];

        loop:
        for(int i = r; i < r + n; i++){
            for(int j = c; j < c + n; j++){
                if(num != arr[i][j]) {
                    flag = false;
                    break loop;
                }
            }
        }

        if(flag){
            bw.write(num + "");
        }
        else{
            bw.write("(");
            solve(r, c, n / 2);
            solve(r, c + n / 2, n / 2);
            solve(r + n / 2, c , n / 2);
            solve(r + n / 2, c + n / 2, n / 2);
            bw.write(")");
        }

    }

}
