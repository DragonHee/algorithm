package backjoon.dynamic;

import java.io.*;

public class Backjoon1904 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int[] tileArr;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        tileArr = new int[n + 1];
        tileArr[0] = 1;
        tileArr[1] = 1;
        bw.write(solve(n)  + "\n");
        bw.close();
        br.close();
    }
    private static int solve(int n){
        for(int i = 2; i <= n; i++){
            tileArr[i] = (tileArr[i - 1] + tileArr[i - 2]) % 15746;
        }
        return tileArr[n];
    }
}
