package backjoon.samsung_sw_test;

import java.io.*;
import java.util.*;


public class Backjoon13458 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, B, C;
    static int arr[];
    static long answer = 0;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N + 1];

        for(int i = 1 ; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        solve();

        bw.write(answer + "\n");
        bw.close();
        br.close();
    }

    static void solve(){
        for(int i = 1; i <= N; i++){
            calcMinNum(arr[i]);
        }
    }

    static void calcMinNum(int num){
        int count = 1;

        num -= B;

        if(num > 0){
            count += num / C;
            if(num % C != 0) count++;    
        }
       
        answer += count;
    }
    
}
