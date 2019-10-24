package backjoon.math;

import java.io.*;
import java.util.StringTokenizer;

public class Backjoon2609 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int ans1 = gcd(a, b);
        int ans2 = a * b / ans1;
        bw.write(ans1 + "\n" + ans2 + "\n");
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
