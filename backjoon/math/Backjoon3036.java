package backjoon.math;

import java.io.*;
import java.util.StringTokenizer;

public class Backjoon3036 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int [] arr = new int[n + 1];

        for(int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        for(int i = 2; i <= n; i++){
            int r = gcd(arr[1], arr[i]);
            bw.write(arr[1] / r + "/" + arr[i] / r + "\n");
        }
        bw.close();
        br.close();
    }
    public static int gcd(int a, int b){
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
