package backjoon.dp_minpath;

import java.io.*;

public class Backjoon12852 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[n + 1];

        for(int i = 2; i <= n; i++){
            int num1 = Integer.MAX_VALUE;
            int num2 = Integer.MAX_VALUE;
            int num3;

            if(i % 3 == 0) num1 = dp[i / 3];
            if(i % 2 == 0) num2 = dp[i / 2];
            num3 = dp[i - 1];

            dp[i] = Math.min(num1, Math.min(num2, num3)) + 1;
        }

       sb.append(dp[n] + "\n");

        int num = dp[n];
        int index = n;

        while (true){
            sb.append(index + " ");

            if(num == 0) break;

            if(index % 3 == 0 && dp[index / 3] == num - 1)
                index = index / 3;
            else if(index % 2 == 0 && dp[index / 2] == num - 1)
                index = index / 2;
            else
                index = index - 1;

            num--;
        }
        bw.write(sb.toString());

        bw.close();
        br.close();
    }
}
