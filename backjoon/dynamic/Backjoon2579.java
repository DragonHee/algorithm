package backjoon.dynamic;

import java.io.*;

public class Backjoon2579 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] stairArr;
    private static int[] dpArr;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        stairArr = new int[n + 1];
        dpArr = new int[n + 1];

        for(int i = 1; i <= n; i++) stairArr[i] = Integer.parseInt(br.readLine());

        if(n >= 3) {
            dpArr[1] = stairArr[1];
            dpArr[2] = stairArr[1] + stairArr[2];
            dpArr[3] = max(stairArr[2] + stairArr[3], stairArr[1] + stairArr[3]);
        }else {
            for(int i = 1; i <= n; i++){
                dpArr[i] = dpArr[i - 1] + stairArr[i];
            }
        }
        for(int i = 4; i <= n; i++){
            dpArr[i] = max(dpArr[i - 3] + stairArr[i - 1] + stairArr[i], dpArr[i - 2] + stairArr[i]);
        }
        bw.write(dpArr[n] + "\n");
        bw.close();
        br.close();
    }
    private static int max(int a, int b){
        return a > b ? a : b;
    }
}
