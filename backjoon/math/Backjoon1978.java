package backjoon.math;

import java.io.*;
import java.util.StringTokenizer;

public class Backjoon1978 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int answer;

    public static void main(String[] args) throws IOException {
        int testCnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0 ; i < testCnt; i++){
            if(checkPrimeNum(Integer.parseInt(st.nextToken()))){
                answer++;
            }
        }
        bw.write(answer + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean checkPrimeNum(int num) throws IOException {
        int divisionNum = 2;

        if(num == 1) return false;

        while(divisionNum <= Math.sqrt(num)){
            if(num % divisionNum++ == 0) {
                return false;
            }
        }
        return true;
    }
}
