package backjoon.backtracking;

import java.io.*;

public class Backjoon9663 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int col[];
    private static int n;
    private static int ans;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        col = new int[n + 1];

        for(int i = 1; i <= n; i++){
            col[1] = i;
            solve(2);
        }
        bw.write(ans + "\n");
        bw.close();
        br.close();
    }
    private static void solve(int r){
        if(r == n + 1){
            ans++;return;
        }
        for(int i = 1; i <= n; i++){
            if(isPossible(r, i)) {
                col[r] = i;
                solve(r + 1);
            }
        }
    }
    private static boolean isPossible(int r, int c){
        for(int i = 1; i <= r - 1; i++){
            if(col[i] == c || Math.abs(r - i) == Math.abs(c - col[i])) return false;
        }
        return true;
    }
}
