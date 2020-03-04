package backjoon.useif;

import java.io.*;

public class Backjoon5543 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        int burger[] = new int[3];
        int beverage[] = new int[2];

        for(int i = 0; i < burger.length; i++)
            burger[i] = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < beverage.length; i++)
            beverage[i] = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < burger.length; i++){
            for(int j = 0 ; j < beverage.length; j++){
                int total = burger[i] + beverage[j] - 50;
                answer = total < answer ? total: answer;
            }
        }

        bw.write(answer + "\n");
        bw.close();
        br.close();
    }
}
