import java.io.*;
import java.util.StringTokenizer;

public class Backjoon6064 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int testCnt = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < testCnt; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            bw.write(calcYear(m, n, x, y) + "\n");
            bw.flush();
        }
    }
    private static int calcYear(int m, int n, int x, int y){
        int cnt = lcm(m, n) / m;
        int a = 0;
        int k = 1;
        boolean flag = false;

        if(y == n) flag = true;

        if(flag){
            while(cnt-- > 0){
                if((a * m + x) % n == 0) return a * m + x;
                a++;
            }
        }else{
            while(cnt-- > 0){
                if((a * m + x) % n == y) return m * a + x;
                a++;
            }
        }

        return -1;
    }
    private static int gcd(int a, int b){
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    private static int lcm(int a, int b){
        return a * b / gcd(a, b);
    }
}
