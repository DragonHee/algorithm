package backjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon1010 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int westCnt = Integer.parseInt(st.nextToken());
            int eastCnt = Integer.parseInt(st.nextToken());

            int combination[][] = new int[eastCnt + 1][eastCnt + 1];

            for(int i = 1; i <= eastCnt; i++)
                combination[i][0] = 1;

            for(int i = 1; i <= eastCnt; i++){
                for(int j = 1; j <= i; j++){
                    if(i == j) combination[i][j] = 1;
                    else combination[i][j] = combination[i - 1][j] + combination[i - 1][j - 1];
                }
            }

            sb.append(combination[eastCnt][westCnt] + "\n");
        }
        System.out.println(sb);
    }
}
