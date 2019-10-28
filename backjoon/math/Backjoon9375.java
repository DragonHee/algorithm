package backjoon.math;

import java.io.*;
import java.util.Arrays;

public class Backjoon9375 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int testCnt = Integer.parseInt(br.readLine());
        String[] arr;
        String input;
        for(int i = 0; i < testCnt; i++){
            int n = Integer.parseInt(br.readLine());
            arr = new String[n];

            for(int j = 0 ; j < n; j++){
                input = br.readLine();
                arr[j] = input.substring(input.indexOf(" ") + 1);
            }
            Arrays.sort(arr);


            int ans = 1;
            int count = 2;

            for(int j = 0 ; j < arr.length - 1; j++){
                if(arr[j].equals(arr[j + 1])){
                    count++;
                }else{
                    ans *= count;
                    count = 2;
                }
            }
            ans *= count;
            if(n == 0) ans = 1;
            bw.write(ans - 1 + "\n");
        }
        bw.close();
        br.close();
    }
}
