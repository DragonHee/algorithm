package backjoon.dynamic;

import java.io.*;

public class Backjoon10844 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        long answer = 9;
        while(true){
            if(--n == 0) break;
            answer = answer * 2 - 1;
        }
        bw.write(answer + "\n");
        bw.close();
        br.close();
    }
}
