package backjoon.function;

import java.io.*;

public class Backjoon10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        bw.write(factorial(n) + "\n");
        bw.close();
    }
    public static int factorial(int n){
        int res = 1;
        for(int i = 1 ; i <= n ; i++){
            res *= i;
        }
        return res;
    }
}
