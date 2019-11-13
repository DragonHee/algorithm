package backjoon.divideandconquer;

import java.io.*;
import java.util.StringTokenizer;

public class Backjoon1780 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int arr[][];
    static int minusOneCnt, zeroCnt, oneCnt;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(1,1, n);
        bw.write(minusOneCnt + "\n" + zeroCnt + "\n" + oneCnt + "\n");
        bw.close();
        br.close();
    }
    static void solve(int r, int c, int n) {
        if(n == 1){
            if(arr[r][c] == -1) minusOneCnt++;
            else if(arr[r][c] == 0) zeroCnt++;
            else oneCnt++;
            return;
        }

        boolean flag = true;
        int num = arr[r][c];

        loop:
        for(int i = r; i < r + n; i++){
            for(int j = c; j < c + n; j++){
                if(num != arr[i][j]){
                    flag = false;
                    break loop;
                }
            }
        }

        if(flag){
            if(num == -1) minusOneCnt++;
            else if(num == 0) zeroCnt++;
            else oneCnt++;
        }
        else{
            for(int i = 0; i < 3; i++){
                for(int j = 0 ; j < 3; j++){
                    solve(r + i * n / 3, c + j * n / 3, n / 3);
                }
            }
        }
    }
}
