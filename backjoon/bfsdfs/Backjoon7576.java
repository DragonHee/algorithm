package backjoon.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon7576 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int arr[][] = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int zero = 0, one = 0, minusOne = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(arr[i][j] == 0) zero++;
            }
        }

        if(zero == 0) {
            System.out.println(0);
            return;
        }
    }
}
