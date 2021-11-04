package backjoon.bruteforce;

import java.util.*;
import java.io.*;

public class Backjoon1057 {
    static class Index{
        int curNum;
        int realNum;

        public Index(int curNum, int realNum){
            this.curNum = curNum;
            this.realNum = realNum;
        }
    }

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, A, B;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 총 참여 인원 Input
        N = Integer.parseInt(st.nextToken());
        // 김지민 번호 Input
        A = Integer.parseInt(st.nextToken());
        // 임한수 번호 Input
        B = Integer.parseInt(st.nextToken());

        int answer = solve();

        bw.write(answer + "\n");
        bw.close();
        br.close();
    }

    public static int solve(){
        // 진행된 라운드 수
        int roundNum = 0;

        ArrayList<Index> list = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            list.add(new Index(i, i));
        }

        return roundNum;
    }
}
