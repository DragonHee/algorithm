package backjoon.dp_minpath;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Backjoon12852 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int result;
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

        result = dp[n];
        bw.write(result + "\n");
        int num = result;
        int index = n;
        while (true){
            if(num == 0) break;

            if(dp[index] == num){
                bw.write(index + " ");
                if(index % 3 == 0 && dp[index / 3] == num - 1){
                    index = index / 3;
                }else if(index % 2 == 0 && dp[index / 2] == num - 1) {
                    index = index / 2;
                    bw.write("\n");
                }else{
                    index = index - 1;
                }

                num--;
            }



        }
        for(int i = 1; i <= n; i++){
            System.out.print(i + "\t");
        }
        System.out.println();
        for(int i = 1; i <= n; i++){
            System.out.print(dp[i] + "\t");
        }
        bw.write(result + "\n");

        bw.close();
        br.close();
    }
}
