package backjoon.divideandconquer;

import java.io.*;
import java.util.StringTokenizer;

public class Backjoon11401 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long ans = solve(n, k);
        bw.write(ans + "\n");
        bw.close();
        br.close();


    }
    public static long solve(int n, int k){
        return 1;
    }
}
