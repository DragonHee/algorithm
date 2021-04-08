package backjoon.combination;

import java.io.*;

public class Backjoon3049 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int input;

    public static void main(String[] args) throws IOException{
        int result;

        input = Integer.parseInt(br.readLine());
        
        result = 0;

        if(input >= 4) result = combination(input, 4);

        bw.write(result + "\n");
        bw.close();
        br.close();
    }

    static int combination(int n, int r){
        if(n == r) return 1;
        if(r == 1) return n;

        return combination(n - 1, r) + combination(n - 1, r - 1);
    }
    
}
