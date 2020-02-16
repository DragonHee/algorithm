package backjoon.dp_minpath;


import java.io.*;
import java.util.StringTokenizer;

public class Backjoon14002 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n + 1];
        int dp[] = new int[n + 1];
        int result = 0;
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            for(int j = 0 ; j < i; j++){
                if(arr[i] > arr[j]){
                   dp[i] = Math.max(dp[j] + 1, dp[i]);
                   result = Math.max(dp[i], result);
                }
            }
        }

        int value = result;
        int index = result;
        int resultArr[] = new int[result];

        for(int i = n; i >= 1; i--){
            if(value == dp[i]) {
                resultArr[--index] = arr[i];
                value--;
            }
        }

        for(int i = 0; i < result; i++)
            sb.append(resultArr[i] + " ");

        bw.write(result + "\n");
        bw.write(sb.toString());

        bw.close();
        br.close();
     }
}
