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

            // 왼쪽 node, 오른쪽 node갯수 저장
            int westCnt = Integer.parseInt(st.nextToken());
            int eastCnt = Integer.parseInt(st.nextToken());

            // nCr 결과를 저장할 배열 선언
            int combination[][] = new int[eastCnt + 1][eastCnt + 1];

            // nCr에서 r == 0 인 경우 1이므로 초기화한다.
            for(int i = 1; i <= eastCnt; i++)
                combination[i][0] = 1;

            for(int i = 1; i <= eastCnt; i++){
                for(int j = 1; j <= i; j++){
                    // nCr에서 n == r인 경우 1
                    if(i == j) combination[i][j] = 1;
                    // f(n, k) = f(n - 1, k) + f(n - 1, k - 1)이므로
                    // 아래와 같은 식을 수행한다.
                    else combination[i][j] = combination[i - 1][j] + combination[i - 1][j - 1];
                }
            }

            sb.append(combination[eastCnt][westCnt] + "\n");
        }
        System.out.println(sb);
    }
}
