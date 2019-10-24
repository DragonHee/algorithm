package backjoon.math;

import java.io.*;

public class Backjoon11653 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for(int i = 2; i <= n; i++){
            if(n % i == 0) {
                bw.write(i + "\n");
                n /= i--;
            }
        }
        bw.close();
        br.close();
    }
}
