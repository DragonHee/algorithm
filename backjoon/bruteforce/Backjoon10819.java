package backjoon.bruteforce;

import java.util.*;
import java.io.*;

public class Backjoon10819 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[] arr;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException{
        // N Input
        N = Integer.parseInt(br.readLine());
        // 배열 선언
        arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 배열에 입력 값 저장
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 문제 해결
        solve();

        bw.write(answer + "\n");

        bw.close();
        br.close();
    }

    public static void solve(){
        Stack<Integer> stk = new Stack<>();
        boolean[] isUsed = new boolean[N + 1];
        int curNum = 1;

        for(int i = 1; i <= N; i++){
            isUsed[i] = true;
            stk.push(arr[i]);
            combination(isUsed, stk, curNum + 1);
            stk.pop();
            isUsed[i] = false;
        }
    }

    // backtracking
    // bruteforce
    public static void combination(boolean[] isUsed, Stack<Integer> stk, int curNum){
        if(curNum > N){
            List<Integer> list = new ArrayList<>(stk);
            int tot = 0;

            for(int i = 0; i < list.size() - 1; i++){
                tot += Math.abs(list.get(i) - list.get(i + 1));
            }

            answer = Math.max(answer, tot); 

            return;
        }

        for(int i = 1; i <= N; i++){
            if(isUsed[i] == true) continue;

            isUsed[i] = true;
            stk.push(arr[i]);
            combination(isUsed, stk, curNum + 1);
            stk.pop();
            isUsed[i] = false;
        }
    }

}
