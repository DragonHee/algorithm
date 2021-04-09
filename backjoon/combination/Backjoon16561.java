package backjoon.combination;
import java.io.*;

public class Backjoon16561 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int result;
    static int input;
    public static void main(String[] args) throws IOException{
        input = Integer.parseInt(br.readLine());

        solve();

        bw.write(result + "\n");

        bw.close();
        br.close();
   }

   static void solve(){
        result = combination(input / 3 - 1, 2);
   }
   static int combination (int n, int r){
        if(n == 0) return 0;
        if(n == r) return 1;
        if(r == 1) return n;

        return combination(n - 1, r - 1) + combination(n - 1, r);
   }
}
