package backjoon.dynamic;

import java.io.*;

public class Backjoon11726 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;
    private static int arr[];

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        arr[0] = 1;
        arr[1] = 1;


        for(int i = 2; i <= N; i++){
            arr[i] = (arr[i - 1] + arr[i - 2]) % 10007;
            //bw.write(arr[i] + "\n");
        }

        bw.write(arr[N] + "\n");
        bw.close();
        br.close();

    }
    
}
