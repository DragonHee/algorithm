package backjoon.math;


import java.io.*;
import java.util.StringTokenizer;

public class Backjoon5086 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int a, b;
        while(true){
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if(a == 0 && b == 0) break;
            if(b % a == 0) bw.write("factor" + "\n");
            else if(a % b == 0) bw.write("multiple" + "\n");
            else bw.write("neither" + "\n");
        }
        bw.close();
        br.close();
    }
}
