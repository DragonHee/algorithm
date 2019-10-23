package backjoon.math;

import java.io.*;
import java.util.StringTokenizer;

public class Backjoon2869 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

       bw.write(calcDays(a, b, v) + "\n");
       bw.flush();
       br.close();
       bw.close();
    }
    private static int calcDays(int upLength, int downLength, int totalHeight){
        double answer = (totalHeight - downLength) / (double)(upLength - downLength);
        return (int)Math.ceil(answer);
    }
}
