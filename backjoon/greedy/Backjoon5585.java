package backjoon.greedy;

import java.util.*;
import java.io.*;

public class Backjoon5585 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int input;
    static int cnt500, cnt100, cnt50, cnt10, cnt5, cnt1;
    static int output;
    static final int MONEY = 1000;

    public static void main(String[] args) throws IOException{
        input = Integer.parseInt(br.readLine());

        // 문제 해결 메소드 출력
        solve(input);

        // 결과값 출력 부분
        bw.write(output + "\n");
        br.close();
        bw.close();
    }

    static void solve(int input){
        int remain = MONEY - input;

        output += cnt500 = remain / 500;
        remain = remain - 500 * cnt500;

        output += cnt100 = remain / 100;
        remain = remain - 100 * cnt100;

        output += cnt50 = remain / 50;
        remain = remain - 50 * cnt50;

        output += cnt10 = remain / 10;
        remain = remain - 10 * cnt10;

        output += cnt5 = remain / 5;
        remain = remain - 5 * cnt5;

        output += cnt1 = remain / 1;
    }
}
