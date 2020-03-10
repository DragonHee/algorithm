package backjoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;
        int num;
        int max = -1000000, min = 1000000;


        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        while(st.hasMoreTokens()){
            num = Integer.parseInt(st.nextToken());
            if(num >= max) max = num;
            if(num <= min) min = num;
        }

        System.out.println(min + " " + max);
    }
}
