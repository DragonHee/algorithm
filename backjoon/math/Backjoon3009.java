package backjoon.math;

import java.io.*;
import java.util.StringTokenizer;

public class Backjoon3009 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int x1, y1, x2, y2, x3, y3, x4 = 0, y4 = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        x3 = Integer.parseInt(st.nextToken());
        y3 = Integer.parseInt(st.nextToken());

        if (x1 == x2){
            if (y1 == y3) {
                x4 = x3;
                y4 = y2;
            } else if(y2 == y3) {
                x4 = x3;
                y4 = y1;
            }
        }else if(x1 == x3){
            if(y1 == y2){
                x4 = x2;
                y4 = y3;
            }else if(y2 == y3){
                x4 = x2;
                y4 = y1;
            }
        }else if(x2 == x3){
            if(y1 == y2){
                x4 = x1;
                y4 = y3;
            }else if(y1 == y3){
                x4 = x1;
                y4 = y2;
            }
        }
        bw.write(x4 + " " + y4 + "\n");
        bw.close();
        br.close();
    }
}
