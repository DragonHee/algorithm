package backjoon.bruteforce;

import java.io.*;

public class Backjoon2231 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int sum;
        int current;
        int answer = 0;

        for(int i = n ; i >= 1; i--){
            sum = 0;
            current = i;
            while (current / 10 != 0){
                sum += current % 10;
                current = current / 10;
            }
            sum += current;
            sum += i;
            if(sum == n) answer = i;
        }

        bw.write(answer + "\n");
        bw.close();
        br.close();
    }
}
