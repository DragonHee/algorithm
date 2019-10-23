package backjoon.math;

import java.io.*;
import java.util.StringTokenizer;

public class Backjoon1002 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int testCnt = Integer.parseInt(br.readLine());
        int x1, y1, r1, x2, y2, r2;
        StringTokenizer st;

        for(int i = 0 ; i < testCnt; i++){
            st = new StringTokenizer(br.readLine(), " ");
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            r1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());

            double distance = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));

            if(x1 == x2 && y1 == y2 && r1 == r2) bw.write( -1 + "\n");
            else if(x1 == x2 && y1 == y2) bw.write(0 + "\n");
            else {
                if(r1 > r2){
                    if(distance + r2 < r1) bw.write(0 + "\n");
                    else if(distance + r2 == r1) bw.write(1 + "\n");
                    else{
                        if (distance > r1 + r2) bw.write(0 + "\n");
                        else if (distance == r1 + r2) bw.write(1 + "\n");
                        else if (distance < r1 + r2) bw.write(2 + "\n");
                    }
                }
                else{
                    if(distance + r1 < r2) bw.write(0 + "\n");
                    else if(distance + r1 == r2) bw.write(1 + "\n");
                    else{
                        if (distance > r1 + r2) bw.write(0 + "\n");
                        else if (distance == r1 + r2) bw.write(1 + "\n");
                        else if (distance < r1 + r2) bw.write(2 + "\n");
                    }
                }
            }
        }
        br.close();
        bw.close();
    }
}
