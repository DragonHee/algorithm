package backjoon.divideandconquer;

import java.io.*;
import java.util.StringTokenizer;

public class Backjoon9471 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int testNum = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            long result;

            result = calc(m);
            bw.write(testNum + " " + result + "\n");
        }
        bw.close();
        br.close();
    }
    public static long calc(int m) {
        long result = 1;
        int arr[] = new int[3];
        arr[0] = 0; arr[1] = 1;

        while(true){
            arr[2] = (arr[0] + arr[1]) % m;
            arr[0] = arr[1];
            arr[1] = arr[2];
            if(arr[0] == 0 && arr[1] == 1) break;
            result++;
        }
        return result;
    }
}
