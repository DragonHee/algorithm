package backjoon.math;

import java.io.*;

public class Backjoon1676 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int curVal;
        int count = 0;

        for(int i = 1; i <= n; i++){
            curVal = i;
            while(curVal % 5 == 0){
                curVal = curVal / 5;
                count++;
            }
        }

        bw.write(count + "\n");
        bw.close();
        br.close();
    }
}
