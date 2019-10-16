package backjoon.dynamic;

import java.io.*;
import java.util.StringTokenizer;

public class Backjoon11054 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n + 2];
        int[] dp1 = new int[n + 2];
        int[] dp2 = new int[n + 2];
        int max = 0;

        for(int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        for(int i = 1; i <=n; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]){
                    dp1[i] = max(dp1[i], dp1[j] + 1);
                }
            }
        }
        for(int i = n; i >= 1; i--){
            for(int j = n + 1; j > i; j--){
                if(arr[i] > arr[j]) dp2[i] = max(dp2[i], dp2[j] + 1);
            }
        }
        for(int i = 1; i <= n; i++) {
            max = max(max, dp1[i] + dp2[i] - 1);
        }

        bw.write(max + "\n");
        bw.close();
        br.close();
    }
    public static int max(int a, int b){return a > b ? a : b;}
}
