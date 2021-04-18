package backjoon.samsung_sw_test;

import java.util.*;
import java.io.*;

public class Backjoon14888 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
    static int[] numArr;
    static int[] calcArr;
    static boolean[] check;
    static int N;
    static int minValue = Integer.MAX_VALUE, maxValue = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        numArr = new int[N + 1];
        calcArr = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) numArr[i] = Integer.parseInt(st.nextToken());

        st= new StringTokenizer(br.readLine());
        for(int i = 0; i < calcArr.length; i++) calcArr[i] = Integer.parseInt(st.nextToken());

        solve();

        bw.write(maxValue + "\n" + minValue + "\n");
        bw.close();
        br.close();
    }
    
    static void solve(){
        int num = numArr[1];

        for(int i = 0; i < calcArr.length; i++){
            // 연산자 다 사용 시 생략
            if(calcArr[i] == 0) continue;
            int calcNum = 0;

            // 연산자 갯수 1 감소
            calcArr[i]--;
            if(i == 0) calcNum = num + numArr[2];
            else if(i == 1) calcNum = num - numArr[2];
            else if(i == 2) calcNum = num * numArr[2];
            else calcNum = num / numArr[2];

            // 조합
            combination(2, calcNum);
            // 연산자 갯수 1증가
            calcArr[i]++;
        }
    }

    static void combination(int count, int num){
        if(count == N){
            minValue = Math.min(minValue, num);
            maxValue = Math.max(maxValue, num);

            return;
        }

        for(int i = 0; i < calcArr.length; i++){
            // 연산자 다 사용 시 생략
            if(calcArr[i] == 0) continue;
            int calcNum = 0;
            // 연산자 갯수 1 감소
            calcArr[i]--;
           
            if(i == 0) calcNum = num + numArr[count + 1];
            else if(i == 1) calcNum = num - numArr[count + 1];
            else if(i == 2) calcNum = num * numArr[count + 1];
            else calcNum = num / numArr[count + 1];

            combination(count + 1, calcNum);
            // 연산자 갯수 1증가
            calcArr[i]++;
        }
    }
    
}
