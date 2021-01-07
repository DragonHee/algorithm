package backjoon.dynamic;

import java.io.*;

public class Backjoon2133 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int arr[] = new int[31];

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        arr[0] = 1;

        for(int i = 2; i <= N; i++){
            if(i % 2 == 1) continue;
            arr[i] = arr[i - 2] * 3;
            for(int j = 0; j <= i - 4; j += 2)
            {
                arr[i] += arr[j] * 2;
            }
        }
        
        bw.write(arr[N] + "\n");
        bw.close();
        br.close();
    }
}
