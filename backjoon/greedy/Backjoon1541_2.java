package backjoon.greedy;

import java.io.*;

public class Backjoon1541_2 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split("-");
        int ans = 0;

        String[] arr = input[0].split("\\+");
        for(int i = 0 ; i < arr.length; i++){
            ans += Integer.parseInt(arr[i]);
        }
        for(int i = 1; i < input.length; i++){
            arr = input[i].split("\\+");
            for(int j = 0 ; j < arr.length; j++){
                ans -= Integer.parseInt(arr[j]);
            }
        }
        bw.write(ans + "\n");
        bw.close();
        br.close();
    }
}
