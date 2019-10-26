package backjoon.math;

import java.io.*;
import java.util.StringTokenizer;

public class Backjoon11050 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        bw.write(factorial(n) / (factorial(k) * factorial(n - k)) + "\n");
        bw.close();
        br.close();
    }
    public static int factorial(int n){
        int fac = 1;
        for(int i = 1; i <= n; i++) fac *= i;
        return fac;
    }
}
