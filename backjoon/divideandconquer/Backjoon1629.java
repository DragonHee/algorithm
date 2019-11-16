package backjoon.divideandconquer;

import java.io.*;
import java.util.StringTokenizer;

public class Backjoon1629 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int a, b, c;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        long ans = pow(a, b);
        bw.write(ans + "\n");

        bw.close();
        br.close();
    }
    static long pow(int a, int b){
        if(b == 0){
            return 1;
        }
        long n = pow(a, b / 2);
        long temp = n * n % c;

        if(b % 2 == 0) return temp;
        else return temp * a % c;
    }
}
