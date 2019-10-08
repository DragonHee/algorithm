package backjoon.bruteforce;

import java.io.*;

public class Backjoon1436 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int answer = 666;
        int count = 0;
        String checkAnswer;
        while(true){
            checkAnswer = String.valueOf(answer);
            if(checkAnswer.contains("666")) count++;
            if(count == n){
                bw.write(answer + "\n");
                break;
            }
            answer++;
        }

        bw.close();
        br.close();
    }
}
