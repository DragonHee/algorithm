package backjoon.dynamic;

import java.io.*;
import java.util.Arrays;

public class Backjoon2748 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static long[] fibArr;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        fibArr = new long[n + 1];
        bw.write(fibonacci(n) + "\n");
        bw.close();
        br.close();
    }
    private static long fibonacci(int n){
        if(n == 1 || n == 2){
            return 1;
        }else if(fibArr[n] > 0){
            return fibArr[n];
        }else{
            fibArr[n] = fibonacci(n - 1) + fibonacci(n - 2);
            return fibArr[n];
        }
    }
}
