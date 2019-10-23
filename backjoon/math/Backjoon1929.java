package backjoon.math;

import java.io.*;
import java.util.StringTokenizer;

public class Backjoon1929 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        printPrimeNum(m, n);

        bw.close();
        br.close();
    }
    private static void printPrimeNum(int m , int n) throws IOException {
        int[] arr = new int[n + 1];

        for(int i = 2; i <= n; i++){
            arr[i] = i;
        }

        for(int i = 2; i <= Math.sqrt(n); i++){
            if(arr[i] == 0) continue;
            for(int j = 2 * i; j <= n; j += i){
                arr[j] = 0;
            }
        }

        for(int i = m; i <= n; i++){
            if(arr[i] != 0) bw.write(arr[i] + "\n");
        }
    }
}
