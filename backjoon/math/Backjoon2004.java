package backjoon.math;


import java.io.*;
import java.util.StringTokenizer;

public class Backjoon2004 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long twoCnt = 0;
        long fiveCnt = 0;

        for(long i = 2; i <= n; i *= 2) twoCnt += n / i;
        for(long i = 2; i <= n - m; i *= 2) twoCnt -= (n - m) / i;
        for(long i = 2; i <= m; i *= 2) twoCnt -= m / i;

        for(long i = 5; i <= n; i *= 5) fiveCnt += n / i;
        for(long i = 5; i <= n - m; i *= 5) fiveCnt -= (n - m) / i;
        for(long i = 5; i <= m; i *= 5) fiveCnt -= m / i;

        bw.write(Math.min(twoCnt, fiveCnt) + "\n");
        bw.close();
        br.close();

    }
}
