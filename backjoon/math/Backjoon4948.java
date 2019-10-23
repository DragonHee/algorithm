package backjoon.math;

import java.io.*;

public class Backjoon4948 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            calcPrimeNumCnt(n);
        }
        br.close();
        bw.close();
    }

    private static void calcPrimeNumCnt(int n) throws IOException {
        int arr[] =  new int[2 * n + 1];
        int cnt = 0;

        for(int i = 2; i <= 2 * n; i++){
            arr[i] = i;
        }

        for(int i = 2; i <= Math.sqrt(2 * n); i++){
            if(arr[i] == 0) continue;
            for(int j = 2 * i; j <= 2 * n; j += i){
                arr[j] = 0;
            }
        }

        for(int i = n + 1; i <= 2 * n; i++){
            if(arr[i] != 0) cnt++;
        }
        bw.write(cnt + "\n");
    }
}
