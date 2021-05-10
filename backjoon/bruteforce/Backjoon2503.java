package backjoon.bruteforce;

import java.io.*;
import java.util.*;

public class Backjoon2503 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[1000];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            int numArr[] = new int[3];

            for(int j = 0 ; j < 3; j++){
                numArr[j] = num % (int)(Math.pow(10, j + 1)) / (int)(Math.pow(10, j));
            }

            for(int j = 100 ; j < 1000; j++){
                // 2번째 검사부터는
                // 이전 검사에서 실패한 경우 생략
                if(i > 0 && arr[j] == false) continue;

                boolean stopFlag = false;
                int[] jArr = new int[3];

                for(int k = 0 ; k < 3; k++){
                    jArr[k] = j % (int)(Math.pow(10, k + 1)) / (int)(Math.pow(10, k));
                }

                for(int k = 0 ; k < 3; k++){
                    if(jArr[k] == 0) {
                        stopFlag = true;
                    }

                    for(int q = k + 1; q < 3; q++){
                        if(jArr[k] == jArr[q]){
                            stopFlag = true;
                        }
                    }
                }

                if(stopFlag) continue;

                boolean[] check = new boolean[3];
                int calcStrike = 0;
                int calcBall = 0;

                for(int k = 0 ; k < 3; k++){
                    if(numArr[k] == jArr[k]){
                        check[k] = true;
                        calcStrike++;
                    }
                }

                for(int k = 0 ; k < 3; k++){
                    if(check[k] == true) continue;
                    for(int q = 0; q < 3; q++){
                        if(k == q) continue;

                        if(numArr[k] == jArr[q]){
                            check[k] = true;
                            calcBall++;
                        }
                    }
                }

                if(calcStrike == strike && calcBall == ball) {
                    if(i == 0) arr[j] = true;
                }
                else{
                    arr[j] = false;
                }
            }
        }

        int answer = 0;

        for(int i = 100; i < 1000; i++){
            if(arr[i] == true) answer++;
        }

        bw.write(answer + "\n");
        bw.close();
        br.close();
    }
}
