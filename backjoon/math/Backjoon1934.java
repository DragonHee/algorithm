package backjoon.math;

import java.util.*;
import java.io.*;

public class Backjoon1934 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
   
    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T; i++){
            int numA, numB;
            StringTokenizer st =  new StringTokenizer(br.readLine());

            numA = Integer.parseInt(st.nextToken());
            numB = Integer.parseInt(st.nextToken());

            int answer = solve(numA, numB);

            bw.write(answer + "\n");
        }

        bw.close();
        br.close();
    }

    public static int solve(int numA, int numB){
        int answer = 0;
        int gcd = gcd(numA, numB);

        // 최소공배수 = A * B / 최대공약수
        answer = (numA * numB) / gcd;

        return answer;
    }

    // 유클리드 호제법을 사용하기 위한 재귀 함수
    public static int gcd(int numA, int numB){
        if(numA % numB == 0) return numB;
        else return gcd(numB, numA % numB);
    }
}
